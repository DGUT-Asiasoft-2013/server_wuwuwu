package com.cloudage.membercenter.controller;
import com.cloudage.membercenter.entity.Bill;
import com.cloudage.membercenter.entity.Commodity;
import com.cloudage.membercenter.entity.User;
import com.cloudage.membercenter.service.IBillService;
import com.cloudage.membercenter.service.ICommodityService;
import com.cloudage.membercenter.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by Administrator on 2016/12/21.
 */
@RestController
@RequestMapping("/wallet")
public class APIWalletControler {

    @Autowired
    IBillService iBillService;

    @Autowired
    IUserService iUserService;

    @Autowired
    ICommodityService iCommodityService;

    @RequestMapping(value="/my_bill", method= RequestMethod.GET)
    public Page<Bill> getCurrentUser(HttpServletRequest request){
        HttpSession session = request.getSession(true);
        Integer uid = (Integer) session.getAttribute("uid");
        return iBillService.findByUserId(uid,0);
    }

    @RequestMapping(value = "/save_bill/{commodity_Id}")
    public Bill savebill(
            @PathVariable int commodity_Id,
            @RequestParam int buyNumber,
            @RequestParam int totalPrice,
            HttpServletRequest request){


        Commodity commodity = iCommodityService.findOne(commodity_Id);
        HttpSession session = request.getSession(true);
        Integer uid = (Integer) session.getAttribute("uid");
        User user = iUserService.findById(uid);
        Bill bill = new Bill();
        bill.setCommodity(commodity);
        bill.setUser(user);
        bill.setBuyNumber(buyNumber);
        bill.setTotalPrice(totalPrice);

        return iBillService.save(bill);
    }

    @RequestMapping(value = "/recharet",method = RequestMethod.POST)
    public boolean recharet(
            @RequestParam int money,
            HttpServletRequest request){
        HttpSession session = request.getSession(true);
        Integer uid = (Integer) session.getAttribute("uid");
        User user = iUserService.findById(uid);
        int oldmoney = user.getMoney();
        money = oldmoney+money;
        user.setMoney(money);
        iUserService.save(user);
                return true;
    }

    @RequestMapping(value = "/checkmoney",method = RequestMethod.GET)
    public int checkmoney(
            HttpServletRequest request){
        HttpSession session = request.getSession(true);
        Integer uid = (Integer) session.getAttribute("uid");
        User user = iUserService.findById(uid);
                return user.getMoney();
    }
}
