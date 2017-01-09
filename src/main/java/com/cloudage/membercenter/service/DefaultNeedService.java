package com.cloudage.membercenter.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cloudage.membercenter.entity.Need;
import com.cloudage.membercenter.entity.User;
import com.cloudage.membercenter.repository.INeedRepository;

@Component
@Service
@Transactional
public class DefaultNeedService implements INeedService{
	@Autowired
	INeedRepository needRepo;


	//	搜索
	@Override
	public Page<Need> searchNeedWithKeyword(String keyword, int page) {
		Sort sort;
		sort = new Sort(Direction.ASC,"endDate");

		PageRequest pageRequest = new PageRequest(page, 10, sort);
		return needRepo.searchNeedWithKeyword(keyword, pageRequest);
	}


	@Override
	public Need findOne(int need_id) {
		return needRepo.findOne(need_id);
	}


	@Override
	public Need save(Need need) {
		// TODO Auto-generated method stub
		return needRepo.save(need);
	}


	@Override
	public List<Need> findAllByUser(User user) {
		// TODO Auto-generated method stub
		return needRepo.findAllByUser(user);
	}


	@Override
	public List<Need> findAllByUserId(Integer userId) {
		// TODO Auto-generated method stub
		return needRepo.findAllByUserId(userId);
	}


	@Override
	public Page<Need> getNeeds(int page) {
		// TODO Auto-generated method stub
		Date date = new Date();
		Sort sort = new Sort(Direction.ASC, "endDate");
		PageRequest pageRequest = new PageRequest(page, 10, sort);
		return needRepo.findNeedList(date,pageRequest);
	}





}
