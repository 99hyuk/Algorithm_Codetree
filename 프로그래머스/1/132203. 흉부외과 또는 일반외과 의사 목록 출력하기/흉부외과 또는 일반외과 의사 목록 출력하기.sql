-- 코드를 입력하세요
SELECT DR_NAME,	DR_ID, MCDP_CD,	HIRE_YMD
from doctor
where MCDP_CD = 'CS' OR MCDP_CD = 'GS'
order by HIRE_YMD DESC, DR_NAME ASC;
