package org.springframework.samples.petclinic.recoveryroom;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecoveryRoomRepository extends CrudRepository<RecoveryRoom, Integer>{
    
	
	
	List<RecoveryRoom> findAll();
	
	@Query("SELECT room FROM RecoveryRoomType room")
    List<RecoveryRoomType> findAllRecoveryRoomTypes();
	
    Optional<RecoveryRoom> findById(int id);
    
    RecoveryRoom save(RecoveryRoom p);
    
    //RecoveryRoomType getRecoveryRoomType(String name);
    
    @Query("SELECT r FROM RecoveryRoom r WHERE r.size>?1")
    List<RecoveryRoom> findBySizeMoreThan(double size);
    
    @Query("SELECT r FROM RecoveryRoomType r WHERE r.name=?1")
    RecoveryRoomType findRecoveryRoomType(String name);
}
