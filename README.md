# RentalCarApplication_ProgrammingFundamentals_4

CENG211 – Programming Fundamentals
Homework #4
In this homework, you are expected to implement a simplified version of the “Rent-a-car
Application” in Java.

You should fulfill the concepts of:

● Exception Handling

● Generics

● Collections

● Object Oriented Design

● UML Class Diagram

● UML Sequence Diagram

In this application, there are two different types of car rental: commercial and individual. Commercial
rental is on a monthly basis and individual rental is on a daily basis. The price is calculated as follow:

daily_price=model_base_price*model-year-ratio

Model Year--------Model Year Ratio 

2022----------------------1

2020 - 2021------------0.95

2017 - 2019-------------0.9

*Please note that discount is available for both individual and commercial customers.
Individual customers rent on a daily basis. The customer may have membership or rent without
being a member. However, the company offers a 10% discount for the members. There is no discount
for the rentals without a membership. The overall price is calculated by multiplying the number of
days and daily_price of the rental car and also 10% discount for the members.

Each customer has an ID. ID format differs for members (12 digit String) and customers without
membership (11 digit integer) which is based on Turkish Republic Identity Number (Hint: Generics).

To illustrate;

ID Number for a member - M12345678910

ID Number for a non-member customer - 12345678910

Commercial customers rent on a monthly basis. All commercial customers have a membership. The
monthly price for commercial customers is calculated by 30 days and daily_price and also special
discount for the customer. The discount differs for the customer status as follows:

Table 1. Discount Table

Customer Type-----Discount

Silver----------------20%

Gold-----------------25%

Platinum------------30%

Similar to individual customers, all commercial customers have an ID (8 digit string). The ID starts
with S, G or P based on the customer type. To illustrate;

Silver member - S1234567

Gold member - G7896321

Platinum member - P9876543

***Please note that the company may add new commercial customer types in the future (Hint:
Interfaces).

The file that consists of different rentals information is given: HW4_Rentals.csv The columns of the
file are given in the following for each different rental type:

Individual Rental: type*, customer ID, number of days, car model, car model year, base price

Commercial Rental: type*, customer ID, number of months, car model, car model year, base price

*Individual rentals are indicated as ‘Individual’ and commercial rentals are indicated as ‘Commercial’
in the given input file.

The application should work as follow:

1. Read the file to process the rentals.
 
a. If customer ID format is not appropriate for customer types, necessary exceptions

should be thrown. (You should think about the exceptions.)

2. Calculate the price of the rentals.
3. 
4. Generate a 7-digit integer rental code for each rental.
5. 
6. The application should calculate some rental statistics as follow:
7. 
a. Total number of cars rented

b. Total number of commercial rentals

c. Total number of commercial rental-month

d. Total number of individual rentals

e. Total number of individual rental-day

f. Total number of rentals of individual non-member customers

g. Total number of rentals of individual member customers

h. Total number of rentals of silver commercial customers

i. Total number of rentals of gold commercial customers

j. Total number of rentals of platinum commercial customers

You are expected to satisfy object-oriented design guidelines.

You are expected to draw a UML Class Diagram, UML Sequence Diagram, and UML Statechart
Diagram in the given scenario. For the UML Sequence Diagram, you should only draw ‘the
‘calculating the rental price of a commercial rental’ part. Please add your csv files and UML diagrams
inside your project.

Sample Output:

Welcome!

Total number of cars rented: …

Total number of commercial rentals: …

Total number of commercial rental-month: …

Total number of individual rentals: …

Total number of individual rental-day: …

Total number of rentals of individual non-member customers: …

Total number of rentals of individual member customers: …

Total number of rentals of silver commercial customers: ….

Total number of rentals of gold commercial customers: …

Total number of rentals of platinum commercial customers: …

Individual Rentals:

No Rental Code Customer ID isMember Number of Days Car Model Model Year Rental Price

1 .…...

2 …….

3 …….

..

Commercial Rentals:

No Rental Code Customer ID Customer Type Number of Months Car Model Model Year Rental Price

1 .…...

2 …….

3 …….

4 …….

..

Important Notes:

1. You can use standard java.io packages to read files. Do NOT use other 3
rd party
libraries.

2. You should use relative paths (e.g. Files/sample.csv) instead of absolute
paths (e.g. C:\\user\\eclipse-workspace\\MyProject\\Files\\sample.csv).

3. To support Turkish characters you may need to change your project’s text file
encoding to UTF8: Right-click on your project (in package explorer) → Properties → Text
file encoding → Other → UTF8 → Apply.

4. You are expected to write clean, readable, and tester-friendly code. Please try to
maximize reusability and prevent redundancy in your methods.

Assignment Rules:

1. In this lecture’s homework, there is no cheating allowed. If any cheating has been
detected, they will be graded as 0 and there will be no further discussion on this.

2. You are expected to submit your homework in groups. Therefore, only one of you will
be sufficient to submit your homework.

3. Make sure you export your homework as an Eclipse project. You can use other IDEs
as well, however, you must test if it is supported by Eclipse.

4. Submit your homework through CMS.

5. Export your Java Project with your assigned group ID (which will be announced on
CMS) as the given format below:
G05_CENG211_HW4.zip

6. Please be informed that your submissions may be anonymously used in software
testing and maintenance research studies. Your names and student IDs will be
replaced with non-identifying strings. If you do not want your submissions to be used
in research studies, please inform the instructor (Dr. Tuglular) via e-mail.

Grading:

Item Marks-----------------------------(Total 100)

Interfaces----------------------------------10

Generics------------------------------------10

Collections (Arraylist operations)-----------5

Exception Handling--------------------------10

Reading Data from Files----------------------5

Remaining Code------------------------------10

UML Class Diagram---------------------------20

UML Sequence Diagram------------------------15

UML Statechart Diagram----------------------15
