# Holiday Service
	This service will have a details about Holiday. There are 4 API services to perform add, update and view holiday details.
	
## ADD Holiday Details
	To Add the holiday details into the existing data.
		Url - /holidayservice/add-holiday
		Method Type - POST
		Request - {
					holiday: string
					date: date
					country: string
					}
	
## Update Holiday Details
	To Update the existing holiday details.
		Url - /holidayservice/update-holiday
		Method Type - PUT
		Request - {
					id: int
					holiday: string
					date: date
					country: string
					}
					
## View Holiday Details
	To View the holiday details.
		Url - /holidayservice/get-all-holidays
		Method Type - GET
		
		Url - /holidayservice/get-holiday-by-id?holidayId=<<int>>
		Method Type - GET
		