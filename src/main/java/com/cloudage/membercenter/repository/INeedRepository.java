package com.cloudage.membercenter.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import com.cloudage.membercenter.entity.User;
import com.cloudage.membercenter.entity.Need;

public interface INeedRepository extends PagingAndSortingRepository<Need, Integer> {
	@Query("from Need need where user.user = ?1")
	List<Need> findAllByUser(User user);

	@Query("from Need need where need.user.id = ?1")
	List<Need> findAllByUserId(Integer userId);
	
	@Query("from Need need where need.text like %?1%")
	Page<Need> searchNeedWithKeyword(String keyword,Pageable page);
}
