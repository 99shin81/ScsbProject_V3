package com.scsb.t.dao;

import com.scsb.t.entity.Template;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TemplateDAO extends JpaRepository<Template, String> {

    Template findByFormName(String formName);
}
