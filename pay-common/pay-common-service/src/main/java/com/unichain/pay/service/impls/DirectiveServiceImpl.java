package com.unichain.pay.service.impls;

import com.unichain.pay.dao.DirectiveMapper;
import com.unichain.pay.entity.Directive;
import com.unichain.pay.service.DirectiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.Optional;


/**
 * @Author lait.zhang@gmail.com
 * @Tel 15801818092
 * @Date 12/2/2019
 * @Description ${Description}
 */
@Service
public class DirectiveServiceImpl implements DirectiveService {
    @Autowired
    private DirectiveMapper directiveMapper;

    @Override
    public DirectiveMapper getCrudRepository() {
        return directiveMapper;
    }


    public Directive getDirectiveByChannelIdAndChannelName(Long channelId, String directiveName) {

        Directive directive = new Directive();
        directive.setChannelId(channelId);
        directive.setName(directiveName);
        Optional<Directive> optional = directiveMapper.findOne(Example.of(directive));
        if (optional.isPresent()) {
            Directive d = optional.get();
            return d;
        }
        return null;
    }
}
