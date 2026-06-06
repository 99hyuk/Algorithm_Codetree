-- 코드를 입력하세요
SELECT month(start_date) as MONTH, CAR_ID, count(*) as RECORDS
from CAR_RENTAL_COMPANY_RENTAL_HISTORY
where car_id in (select car_id from CAR_RENTAL_COMPANY_RENTAL_HISTORY where start_date between '2022-08-01' and '2022-10-31' group by CAR_ID having count(*) >= 5) and month(start_date) between 8 and 10
group by month(start_date), car_id
order by MONTH, CAR_ID DESC