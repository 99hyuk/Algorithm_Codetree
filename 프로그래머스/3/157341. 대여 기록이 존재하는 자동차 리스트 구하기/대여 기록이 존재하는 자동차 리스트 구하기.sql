-- 코드를 입력하세요
SELECT distinct r.car_id
from CAR_RENTAL_COMPANY_CAR r join CAR_RENTAL_COMPANY_RENTAL_HISTORY h on r.car_id = h.car_id
where month(start_date) = 10 and car_type = '세단'
order by car_id desc;