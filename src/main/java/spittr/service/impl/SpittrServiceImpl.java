package spittr.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spittr.dao.SpitterMapper;
import spittr.pojo.Spitter;
import spittr.pojo.SpitterExample;
import spittr.pojo.Spittle;
import spittr.service.SpittrService;

import java.util.ArrayList;
import java.util.List;

@Service
public class SpittrServiceImpl implements SpittrService {
    @Autowired
//    private SpittrMapper spittrMapper;
    private SpitterMapper spitterMapper;

    public List<Spittle> getSpittles(){
        ArrayList<Spittle> spittles = new ArrayList<Spittle>();
        for(int i=0;i<20;i++){
//            spittles.add(new Spittle("spittle"+i,new Date()));
        }
        return spittles;
    }
    public Spitter test(){
        SpitterExample example = new SpitterExample();
        List<Spitter> spitters = spitterMapper.selectByExample(example);
        Spitter spitter = spitters.get(0);
        return spitter;
    }
}
