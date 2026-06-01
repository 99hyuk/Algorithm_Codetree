-- 코드를 작성해주세요
select distinct ID,	EMAIL,	FIRST_NAME,	LAST_NAME
from DEVELOPERS d join  SKILLCODES s on d.skill_code & s.code > 0
where CATEGORY = 'Front End'
order by id;