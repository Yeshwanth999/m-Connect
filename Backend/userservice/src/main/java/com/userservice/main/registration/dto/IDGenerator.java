//package com.userservice.main.registration.dto;
//
//
//import org.hibernate.HibernateException;
//import org.hibernate.engine.spi.SharedSessionContractImplementor;
//import org.hibernate.id.IdentifierGenerator;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import com.userservice.main.repository.UserRepository;
//
//import java.io.Serializable;
//
//@Component
//public class IDGenerator implements IdentifierGenerator {
//
//	@Autowired
//    private UserRepository sequenceGeneratedEntityRepository;
//
////    @Autowired
////    public IDGenerator(UserRepository sequenceGeneratedEntityRepository) {
////        this.sequenceGeneratedEntityRepository = sequenceGeneratedEntityRepository;
////    }
//
//    @Override
//    public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
//      
//    	Long maxId = sequenceGeneratedEntityRepository.findMaxId();
//       
//    	if (maxId == null) {
//            maxId = 0L;
//        }
//        return "SP2515788-M" + (maxId + 1);
//    }
//}
