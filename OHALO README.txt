Ohalo searching solution


NOTE: 
----------------------------------------------------------------------
1. The solutions uses an inbuilt database (h2) to store dictionareis and users of the API info
2. The api is secured with basic auth, 
username = gentest
password = genTest123$
3. The solution is tested using integrated tests on the services and controllers
4. The solution combines the binary search algorithm and the merge sort algorithm to find the indices



API Documentation
-----------------------------------------------------------
BASE_URL = http://localhost:8080/ohalo

1. dictionary entity
	OPERATION				URL(/api/)						HTTP METHOD		
	1. Get a dictionary			/dictionaries/{dictionaryId}				GET			resp - {"id": 1,"entries": ["bo","is"],"is_case_sensitive": true}
	2. Get all dictionaries			/dictionaries						GET			resp - {"id": 1,"entries": ["bo","is"],"is_case_sensitive": true}

	2b.Get dictionaries(paginated)		/dictionaries?page=0&size=1				GET			resp - {"id": 1,"entries": ["bo","is"],"is_case_sensitive": true}

	3. Delete a dictionary			/dictionaries/{dictionaryId}				DELETE			resp - {"recordId": 2,"message": "successful","operation": "DELETE","success": true,"entity": "dictionary"}

	4. Create a dictionary			/dictionaries						POST			req - [{"entry": "toto2","indices": [[1039,1043]]}] resp - {"recordId": 0,"message": "successful","operation": "UPDATE","success": true,"entity": "Dictionary","data": {"id": 2,"entries": ["toto2"],"is_case_sensitive": true}}

	5. Update a dictionary			/dictionaries						PUT			req - [{"id": 1,"entry": "toto2","indices": [[1039,1043]]}] resp - {"recordId": 0,"message": "successful","operation": "UPDATE","success": true,"entity": "Dictionary","data": {"id": 2,"entries": ["toto2"],"is_case_sensitive": true}}

	6. Search a target string(GET)		/api/search?dictionaryId=2&target=The boy is good	GET			resp - [{"entry": "toto2","indices": [[1039,1043]]}]

	7. Search a target string(POST)		/search							POST			req - {"dictionary":2,"target":"boyboy is a good}	resp - [{"entry": "toto2","indices": [[1039,1043]]}]

-----------------------------------------------------------


Thank you.


Frederick.