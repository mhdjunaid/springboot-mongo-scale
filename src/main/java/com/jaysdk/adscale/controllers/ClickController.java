package com.jaysdk.adscale.controllers;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jaysdk.adscale.model.Click;
import com.jaysdk.adscale.repo.ClickRepo;

@RestController
public class ClickController {

    @Autowired
    ClickRepo clickRepository;

    @RequestMapping(method=RequestMethod.GET, value="/clicks")
    public Iterable<Click> click() {
        return clickRepository.findAll();
    }

    @RequestMapping(method=RequestMethod.POST, value="/clicks")
    public Click save(@RequestBody Click click) {
    	clickRepository.save(click);

        return click;
    }

    @RequestMapping(method=RequestMethod.GET, value="/clicks/{id}")
    public Optional<Click> show(@PathVariable String id) {
        return clickRepository.findById(id);
    }

    @RequestMapping(method=RequestMethod.PUT, value="/clicks/{id}")
    public Click update(@PathVariable String id, @RequestBody Click click) {
        Optional<Click> optclick = clickRepository.findById(id);
        Click c = optclick.get();
        if(click.getCountry() != null)
            c.setCountry(click.getCountry());
        if(click.getCity() != null)
            c.setCity(click.getCity());
        if(click.getIp() != null)
            c.setIp(click.getIp());
        if(click.getPartner() != null)
            c.setPartner(click.getPartner());
        if(click.getCampaign() != null)
            c.setCampaign(click.getCampaign());
        clickRepository.save(c);
        return c;
    }

    @RequestMapping(method=RequestMethod.DELETE, value="/contacts/{id}")
    public String delete(@PathVariable String id) {
        Optional<Click> optclick = clickRepository.findById(id);
        Click contact = optclick.get();
        clickRepository.delete(contact);
        return "";
    }
}