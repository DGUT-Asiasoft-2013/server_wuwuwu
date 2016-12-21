package com.cloudage.membercenter.controller;
import com.cloudage.membercenter.entity.Bill;
import com.cloudage.membercenter.entity.Commodity;
import com.cloudage.membercenter.entity.User;
import com.cloudage.membercenter.service.IBillService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by Administrator on 2016/12/21.
 */
@RestController
@RequestMapping("/api")
public class APIWalletControler {

    IBillService iBillService;

    @RequestMapping(value="/my_bill", method= RequestMethod.GET)
    public Page<Bill> getCurrentUser(HttpServletRequest request){
        HttpSession session = request.getSession(true);
        Integer uid = (Integer) session.getAttribute("uid");
        return iBillService.findByUserId(uid,0);
    }

    @RequestMapping(value = "/save_bill/{commodity_id}")
    public Bill savebill(
            @PathVariable int commodity_id,
            HttpServletRequest request){
        Commodity commodity = new Commodity();


        Bill bill = new Bill();
        bill.setCommodity(commodity);

        return iBillService.save(bill);
    }
}
