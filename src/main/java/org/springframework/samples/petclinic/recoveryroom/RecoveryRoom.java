package org.springframework.samples.petclinic.recoveryroom;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import org.springframework.samples.petclinic.model.BaseEntity;

import com.sun.istack.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "recovery_room")
public class RecoveryRoom extends BaseEntity {

	@Column(name = "id")
	Integer id;

	@NotNull
	@Size(min = 3, max = 50)
	String name;

	@NotNull
	@Min(0)
	double size;

	boolean secure;

	@ManyToOne
	@NotNull
    @JoinColumn(name = "recovery_room_type_id" )
	RecoveryRoomType roomType;

}
