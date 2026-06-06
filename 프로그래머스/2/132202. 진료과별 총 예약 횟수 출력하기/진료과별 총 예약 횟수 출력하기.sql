-- 코드를 입력하세요
SELECT MCDP_CD as 진료과코드, count(*) as 5월예약건수
from APPOINTMENT
where substr(APNT_YMD,6, 2) = '05'
group by MCDP_CD
order by 5월예약건수 ASC, 진료과코드 ASC;