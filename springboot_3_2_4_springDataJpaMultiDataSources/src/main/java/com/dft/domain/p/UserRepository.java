package com.dft.domain.p;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @Class Name UserRepository
 * @Author dongfuting
 * @Create In 2018-03-17 23:32
 */
public interface UserRepository extends JpaRepository<User, Long> {
}
