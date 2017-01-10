package com.cloudage.membercenter.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import com.cloudage.membercenter.entity.Need;
import com.cloudage.membercenter.entity.User;

public interface INeedRepository extends PagingAndSortingRepository<Need, Integer> {
	@Query("from Need need where user = ?1")
	List<Need> findAllByUser(User user);

	@Query("from Need need where need.user.id = ?1")
	List<Need> findAllByUserId(Integer userId);
	
	@Query("from Need need where need.user.id = ?1")
	Page<Need> findMy(Integer userId,Pageable page);
	
	@Query("from Need need where need.title like %?1%")
	Page<Need> searchNeedWithKeyword(String keyword,Pageable page);
	
	@Query("from Need need where need.endDate >= ?1 and need.state = 0")
	Page<Need> findNeedList(Date now,Pageable page);
}
