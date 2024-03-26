package com.example.boot13.entity;

import java.util.Date;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Emp {
	@Id
	private Integer empno;
	private String ename;
	private String job;
	private Integer mgr;
	@Temporal(TemporalType.DATE)
	private Date hiredate;
	private Double sal;
	private Double comm;
//	private Integer deptno;
	/*
	 *  Emp 객체 하나는 사원 한명의 정보를 가지고 있다. 
	 *  Dept 객체 하나는 부서 하나의 정보를 가지고 있다.
	 *  Emp 객체 안에 있는 Dept 객체는 Emp 객체가 가지고 했는 해당사원의 부서 정보를 가지게 하고 싶다!!!
	 */
	@ManyToOne
	@JoinColumn(name = "deptno") //여기는 다른 Entity 를 참조하는 칼럼인데 칼럼의 이름은 "deptno" 로 하겠다는 의미
	private Dept dept;
}















