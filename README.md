# AB4 internship technical problem
An backend server that lets you find locations for a holiday.

## Technologies
 Used SpringBoot with Maven and SpringDataJPA to connect to PostgreSQL database and store/querry data about the holliday locations.

## How to run

Please ensure that you have a working database PostgreSQL with the specifications from resources/application.proprieties file. Or modify them to fit your database.

Just hit run button and observe the results in the console

The input file must have the following structure:
 - First row: number of locations
 - on the next number_of_locations rows `Country, County, City, StartDate, EndDate, AvaragePricePerDay, LocationName, NrOfActivities, [And the activities separated by space]`
