package com.unichain.pay.gateway.config;

import com.unichain.framework.exception.ExceptionType;
import com.unichain.framework.exception.UnichainException;
import com.unichain.service.login.dto.Token;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.core.MethodParameter;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodArgumentResolverComposite;
import org.springframework.web.method.support.ModelAndViewContainer;

/**
 * Author lait.zhang@gmail.com
 * Description 请求时对参数做一些处理
 */
@Slf4j
public class TokenResolver extends HandlerMethodArgumentResolverComposite implements HandlerMethodArgumentResolver {
    final static String TOKEN = "Token";
    private RedisTemplate<String, Object> redisTemplate;

    public TokenResolver(RedisTemplate tokenClient) {
        this.redisTemplate = tokenClient;
    }

    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
        //return true;
        return methodParameter.getParameterType().equals(Token.class);
    }

    @Override
    public Object resolveArgument(MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer,
                                  NativeWebRequest nativeWebRequest, WebDataBinderFactory webDataBinderFactory) throws Exception {
        String stoken = nativeWebRequest.getHeader(TOKEN);
        log.info("============================================>Token" + stoken);
        if(!StringUtils.isNotBlank(stoken)){
            throw new UnichainException(ExceptionType.BusinessException,"Token令牌错误");
        }
        Token token = (Token) redisTemplate.opsForValue().get(stoken);
        if(token == null){
            throw new UnichainException(ExceptionType.BusinessException,"请重新登陆");
        }
        return token;
    }
}
