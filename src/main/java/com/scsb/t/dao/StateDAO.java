package com.scsb.t.dao;

import com.scsb.t.entity.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Modifying;

import javax.transaction.Transactional;
import java.util.List;

public interface StateDAO extends JpaRepository<State, Long> {

    @Query(value = "select * from state where current_emp_id= ?1", nativeQuery = true)
    List<State> findByCurrentEmpId(String current_emp_id);

    // 透過Modifying註解完成修改操作
    @Modifying
    @Transactional
    @Query(value = "update State s set s.currentEmpId=?2,s.nowStage=?3, s.nowState=?4 where s.formId=?1")
    void dbUpdate_sign(Long formId, String currentEmpId, Integer nowStage, String nowState);

    State findByFormId(Long formId);

}
