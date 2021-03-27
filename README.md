# Hotel-Reservation-System
HOTEL ROOM RESERVATION
A hotel chain operating in Miami wishes to offer room reservation services over the internet. They
have three hotels in Miami: Lakewood, Bridgewood and Ridgewood. Each hotel has separate
weekday and weekend(Saturday and Sunday) rates. There are special rates for rewards
customers as a part of loyalty programs. Each hotel has a rating assigned to it.
Lakewood with a rating of 3 has weekday rates as 110$ for regular customers and 80$ for
rewards customers. The weekend rates are 90 for regular customers and 80 for a rewards
customer.
Bridgewood with a rating of 4 has weekday rates as 160$ for regular customers and 110$ for
rewards customers. The weekend rates are 60 for regular customers and 50 for a rewards
customer.
Ridgewood with a rating of 5 has weekday rates as 220$ for regular customers and 100$ for
rewards customers. The weekend rates are 150 for regular customers and 40 for a rewards
customer.
Can you write a program to help an online customer find the cheapest hotel?
The input to the program will be a range of dates for a regular or rewards customer. The output should
be
1. The cheapest available hotel.
2. In case of a tie, the hotel with the highest rating should be returned.
3. The additional level of complexity can be introduced by adding blackout dates, which may be
in part 2 of the problem.
INPUT FORMAT: <customer_type>: <date1>, <date2>, <date3>, ...
OUTPUT FORMAT: <name_of_the_cheapest_hotel>
INPUT 1: Regular: 16Mar2009(mon), 17Mar2009(tues), 18Mar2009(wed)
OUTPUT 1: Lakewood
INPUT 2: Regular: 20Mar2009(fri), 21Mar2009(sat), 22Mar2009(sun)
OUTPUT 2: Bridgewood
INPUT 3: Rewards: 26Mar2009(thur), 27Mar2009(fri), 28Mar2009(sat)
OUTPUT 3: Ridgewood
Expectations from the solution:
1. No persistence of any sort needed (DB or File)
2. No UI needed, everything will be driven from command line
3. No need to expose REST/GraphQL APIs
3. Design of application should adhere to SOLID / DRY / YAGNI principles.
○ If a user needs to add a new catalogue item there should not be major change in
architecture and the code.
4. Solution should follow clean code principles.
5. Unit tests must be present
6. No need to use any framework or tool while using libraries is allowed
