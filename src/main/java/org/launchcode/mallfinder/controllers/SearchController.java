package org.launchcode.mallfinder.controllers;

import org.launchcode.mallfinder.models.Address;
import org.launchcode.mallfinder.models.data.MallDao;
import org.launchcode.mallfinder.models.data.StoreDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.launchcode.mallfinder.models.Mall;

@Controller
public class SearchController {
    public String searchLocation = new String();
    public String searchDistance = new String();

    static Iterable<Mall> malls = new ArrayList<>();

    @Autowired
    private MallDao mallDao;

    @Autowired
    private StoreDao storeDao;

    @RequestMapping(value = "",method = RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("title","Mall Finder");
        String desc = "Search for your favorite Shopping Mall!";
        model.addAttribute("description",desc);
        model.addAttribute("searchLocation" ,searchLocation);
        model.addAttribute("searchDistance",searchDistance);

        return "index";
    }

    @RequestMapping(value = "",method =RequestMethod.POST)
    public String processSearchForm(Model model, @RequestParam String location, @RequestParam String distance){
        Boolean isZip = true;
        //addMalls();
        try {
            Integer zip = Integer.valueOf(location);
            malls = mallDao.findByMallAddressZip(zip);
        }
        catch (NumberFormatException e){
            isZip = false;
        }
        if(isZip == false){
            String[] cityState = location.split(",[ ]*");
            malls = mallDao.findByMallAddressCityAndMallAddressState(cityState[0],cityState[1]);
        }
        model.addAttribute("title","Mall Finder");
        String desc = "Search for your favorite Shopping Mall!";
        model.addAttribute("description",desc);
        model.addAttribute("searchLocation" ,searchLocation);
        model.addAttribute("searchDistance",searchDistance);
        //model.addAttribute("malls", mallDao.findByMallAddressZip(zip));
        //model.addAttribute("malls", mallDao.findAll());
        model.addAttribute("malls", malls);

       return "index";

    }
    public  void addMalls(){
        List<Mall> malls = new ArrayList<>();
/*        Address newAddress1 = new Address("291 Chesterfield Mall","Chesterfield","MO",
                63017,38.6631,-90.5771);
        Mall newMall1 = new Mall("Chesterfield Mall",newAddress1,"(636)590-6550");

        malls.add(newMall1);
       // mallDao.save(newMall1);
        Address newAddress2 = new Address("80 W County Center Dr","Des Peres","MO",
                63131,38.6008,-90.4477);
        Mall newMall2 = new Mall("West County Mall",newAddress2,"(314)288-2020");
        malls.add(newMall2);*/

        mallDao.saveAll(malls);
    }
    @RequestMapping(value ="malldetails/{id}", method = RequestMethod.GET)
    public String viewMall(@PathVariable int id, Model model){

        Optional<Mall> m1 = mallDao.findById(id);
        model.addAttribute("currentmall" ,m1.get());
        return "malldetails";
    }
}
