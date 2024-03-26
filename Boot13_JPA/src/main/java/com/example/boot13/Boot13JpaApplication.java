package com.example.boot13;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.boot13.entity.Emp;
import com.example.boot13.entity.Member;
import com.example.boot13.repository.EmpRepository;
import com.example.boot13.repository.MemberRepository;

import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;

/*
 
INSERT INTO DEPT VALUES
	(10,'ACCOUNTING','NEW YORK');
INSERT INTO DEPT VALUES (20,'RESEARCH','DALLAS');
INSERT INTO DEPT VALUES
	(30,'SALES','CHICAGO');
INSERT INTO DEPT VALUES
	(40,'OPERATIONS','BOSTON');
	
INSERT INTO EMP (empno, ename, job, mgr, hiredate, sal, comm, deptno) VALUES
(7369,'SMITH','CLERK',7902,parsedatetime('17-12-1980','dd-MM-yyyy'),800,NULL,20);
INSERT INTO EMP (empno, ename, job, mgr, hiredate, sal, comm, deptno) VALUES
(7499,'ALLEN','SALESMAN',7698,parsedatetime('20-02-1981','dd-MM-yyyy'),1600,300,30);
INSERT INTO EMP (empno, ename, job, mgr, hiredate, sal, comm, deptno) VALUES
(7521,'WARD','SALESMAN',7698,parsedatetime('22-02-1981','dd-MM-yyyy'),1250,500,30);
INSERT INTO EMP (empno, ename, job, mgr, hiredate, sal, comm, deptno) VALUES
(7566,'JONES','MANAGER',7839,parsedatetime('02-04-1981','dd-MM-yyyy'),2975,NULL,20);
INSERT INTO EMP (empno, ename, job, mgr, hiredate, sal, comm, deptno) VALUES
(7654,'MARTIN','SALESMAN',7698,parsedatetime('28-09-1981','dd-MM-yyyy'),1250,1400,30);
INSERT INTO EMP (empno, ename, job, mgr, hiredate, sal, comm, deptno) VALUES
(7698,'BLAKE','MANAGER',7839,parsedatetime('01-05-1981','dd-MM-yyyy'),2850,NULL,30);
INSERT INTO EMP (empno, ename, job, mgr, hiredate, sal, comm, deptno) VALUES
(7782,'CLARK','MANAGER',7839,parsedatetime('09-06-1981','dd-MM-yyyy'),2450,NULL,10);
INSERT INTO EMP (empno, ename, job, mgr, hiredate, sal, comm, deptno) VALUES
(7788,'SCOTT','ANALYST',7566,parsedatetime('13-07-1987','dd-MM-yyyy'),3000,NULL,20);
INSERT INTO EMP (empno, ename, job, mgr, hiredate, sal, comm, deptno) VALUES
(7839,'KING','PRESIDENT',NULL,parsedatetime('17-11-1981','dd-MM-yyyy'),5000,NULL,10);
INSERT INTO EMP (empno, ename, job, mgr, hiredate, sal, comm, deptno) VALUES
(7844,'TURNER','SALESMAN',7698,parsedatetime('08-09-1981','dd-MM-yyyy'),1500,0,30);
INSERT INTO EMP (empno, ename, job, mgr, hiredate, sal, comm, deptno) VALUES
(7876,'ADAMS','CLERK',7788,parsedatetime('13-07-1987','dd-MM-yyyy'),1100,NULL,20);
INSERT INTO EMP (empno, ename, job, mgr, hiredate, sal, comm, deptno) VALUES
(7900,'JAMES','CLERK',7698,parsedatetime('03-12-1981','dd-MM-yyyy'),950,NULL,30);
INSERT INTO EMP (empno, ename, job, mgr, hiredate, sal, comm, deptno) VALUES
(7902,'FORD','ANALYST',7566,parsedatetime('03-12-1981','dd-MM-yyyy'),3000,NULL,20);
INSERT INTO EMP (empno, ename, job, mgr, hiredate, sal, comm, deptno) VALUES
(7934,'MILLER','CLERK',7782,parsedatetime('23-01-1982','dd-MM-yyyy'),1300,NULL,10);
 
  
  
 */

//스프링 boot 필수 설정 어노테이션
@SpringBootApplication
public class Boot13JpaApplication {
	// JPA 기반 Repository 객체 (Dao 객체) 
	@Autowired 
	private MemberRepository repo;
	@Autowired 
	private EmpRepository empRepo;
	
	// JPA EntityManagerFactory 객체 주입 받기 
	@Autowired
	EntityManagerFactory emf;
	
	//이 클래스로 객체가 생성된 이후에 메소드가 자동으로 호출되도록 하는 어노테이션 
	@PostConstruct
	public void initMembers() {
		/*
		 *  emp, dept 셈플 데이터를 JPQL 을 이용해서 넣어주기 
		 */
		
		//EntityManager 객체 얻어내서 
		EntityManager em=emf.createEntityManager();
		//하나의 트랜젝션을 시작한다 
		EntityTransaction tx=em.getTransaction();
		tx.begin();
		try {
			List<String> queries = new ArrayList<>();

			queries.add("INSERT INTO DEPT VALUES (10,'ACCOUNTING','NEW YORK');");
			queries.add("INSERT INTO DEPT VALUES (20,'RESEARCH','DALLAS');");
			queries.add("INSERT INTO DEPT VALUES (30,'SALES','CHICAGO');");
			queries.add("INSERT INTO DEPT VALUES (40,'OPERATIONS','BOSTON');");
			queries.add("INSERT INTO EMP (empno, ename, job, mgr, hiredate, sal, comm, deptno) VALUES (7369,'SMITH','CLERK',7902,parsedatetime('17-12-1980','dd-MM-yyyy'),800,NULL,20);");
			queries.add("INSERT INTO EMP (empno, ename, job, mgr, hiredate, sal, comm, deptno) VALUES (7499,'ALLEN','SALESMAN',7698,parsedatetime('20-02-1981','dd-MM-yyyy'),1600,300,30);");
			queries.add("INSERT INTO EMP (empno, ename, job, mgr, hiredate, sal, comm, deptno) VALUES (7521,'WARD','SALESMAN',7698,parsedatetime('22-02-1981','dd-MM-yyyy'),1250,500,30);");
			queries.add("INSERT INTO EMP (empno, ename, job, mgr, hiredate, sal, comm, deptno) VALUES (7566,'JONES','MANAGER',7839,parsedatetime('02-04-1981','dd-MM-yyyy'),2975,NULL,20);");
			queries.add("INSERT INTO EMP (empno, ename, job, mgr, hiredate, sal, comm, deptno) VALUES (7654,'MARTIN','SALESMAN',7698,parsedatetime('28-09-1981','dd-MM-yyyy'),1250,1400,30);");
			queries.add("INSERT INTO EMP (empno, ename, job, mgr, hiredate, sal, comm, deptno) VALUES (7698,'BLAKE','MANAGER',7839,parsedatetime('01-05-1981','dd-MM-yyyy'),2850,NULL,30);");
			queries.add("INSERT INTO EMP (empno, ename, job, mgr, hiredate, sal, comm, deptno) VALUES (7782,'CLARK','MANAGER',7839,parsedatetime('09-06-1981','dd-MM-yyyy'),2450,NULL,10);");
			queries.add("INSERT INTO EMP (empno, ename, job, mgr, hiredate, sal, comm, deptno) VALUES (7788,'SCOTT','ANALYST',7566,parsedatetime('13-07-1987','dd-MM-yyyy'),3000,NULL,20);");
			queries.add("INSERT INTO EMP (empno, ename, job, mgr, hiredate, sal, comm, deptno) VALUES (7839,'KING','PRESIDENT',NULL,parsedatetime('17-11-1981','dd-MM-yyyy'),5000,NULL,10);");
			queries.add("INSERT INTO EMP (empno, ename, job, mgr, hiredate, sal, comm, deptno) VALUES (7844,'TURNER','SALESMAN',7698,parsedatetime('08-09-1981','dd-MM-yyyy'),1500,0,30);");
			queries.add("INSERT INTO EMP (empno, ename, job, mgr, hiredate, sal, comm, deptno) VALUES (7876,'ADAMS','CLERK',7788,parsedatetime('13-07-1987','dd-MM-yyyy'),1100,NULL,20);");
			queries.add("INSERT INTO EMP (empno, ename, job, mgr, hiredate, sal, comm, deptno) VALUES (7900,'JAMES','CLERK',7698,parsedatetime('03-12-1981','dd-MM-yyyy'),950,NULL,30);");
			queries.add("INSERT INTO EMP (empno, ename, job, mgr, hiredate, sal, comm, deptno) VALUES (7902,'FORD','ANALYST',7566,parsedatetime('03-12-1981','dd-MM-yyyy'),3000,NULL,20);");
			queries.add("INSERT INTO EMP (empno, ename, job, mgr, hiredate, sal, comm, deptno) VALUES (7934,'MILLER','CLERK',7782,parsedatetime('23-01-1982','dd-MM-yyyy'),1300,NULL,10);");

			
			for (String query : queries) {
			    em.createNativeQuery(query).executeUpdate();
			}

			tx.commit();
		}catch(Exception e) {
			e.printStackTrace();
			tx.rollback();
		}finally {
			em.close();
		}
		
		// 사원번호 7900 의 정보 얻어오기 
		Emp e1=empRepo.findById(7900).get();
		System.out.println(e1.getEname()+" 사원의 부서 명은 "+e1.getDept().getDname());
	}

	// run as spring boot app 를 실행하면 여기부터 시작이 된다.
	public static void main(String[] args) {
		SpringApplication.run(Boot13JpaApplication.class, args);
	}

}











