SELECT user(), database();

select title_code,title_name from title;
select * from department;
select * from employee;
select * from title;

select title_code,title_name from title t;

select eno, ename,salary dept_code,dept_name floor,gender,joindate,title_code,title_name
from employee e join department d on e.dno=d.dept_code
join title t on e.title=t.title_code;

select title_code,title_name from title

call salary_total(1);