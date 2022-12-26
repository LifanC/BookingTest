package demo.project.entity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BookingRepository extends JpaRepository<BookingMember,Integer> {
	@Query(value = "select * from booking_member where booking_member.email=?", nativeQuery = true)
    List<BookingMember> queryByEmail(String email);


}

