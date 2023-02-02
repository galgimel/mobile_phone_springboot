package com.spring.springboot.mobile_phone_springboot.dao;

import com.spring.springboot.mobile_phone_springboot.entity.MobilePhone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class MobilePhoneDTOImpl implements MobilePhoneDTO {
    @Autowired
    private EntityManager entityManager;

    @Override
    public List<MobilePhone> getAllMobilePhones() {
       Query query = entityManager.createQuery("from MobilePhone");
        List<MobilePhone> allMobilePhones = query.getResultList();

        return allMobilePhones;
    }

    @Override
    public void saveMobilePhone(MobilePhone mobilePhone) {
        MobilePhone newMobilePhone = entityManager.merge(mobilePhone);

        mobilePhone.setId(newMobilePhone.getId());
    }

    @Override
    public MobilePhone getMobilePhone(int id) {
        MobilePhone mobilePhone = entityManager.find(MobilePhone.class, id);
        return mobilePhone;
    }

    @Override
    public void deleteMobilePhone(int id) {
        Query query = entityManager.createQuery("delete from MobilePhone where id =:mobilePhoneID");
        query.setParameter("mobilePhoneID", id);
        query.executeUpdate();
    }
}
