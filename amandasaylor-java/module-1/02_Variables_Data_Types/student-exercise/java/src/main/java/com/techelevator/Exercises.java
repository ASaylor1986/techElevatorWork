package com.techelevator;

public class Exercises {

	public static void main(String[] args) {

        /*
        1. 4 birds are sitting on a branch. 1 flies away. How many birds are left on
        the branch?
        */

		// ### EXAMPLE:
		int initialNumberOfBirds = 4;
		int birdsThatFlewAway = 1;
		int remainingNumberOfBirds = initialNumberOfBirds - birdsThatFlewAway;
		System.out.println(remainingNumberOfBirds);
		

        /*
        2. There are 6 birds and 3 nests. How many more birds are there than
        nests?
        */

		// ### EXAMPLE:
		int numberOfBirds = 6;
		int numberOfNests = 3;
		int numberOfExtraBirds = numberOfBirds - numberOfNests;
		System.out.println(numberOfExtraBirds);
		
        /*
        3. 3 raccoons are playing in the woods. 2 go home to eat dinner. How
        many raccoons are left in the woods?
        */

		int numberOfRaccoons = 3;
		int numberOfRaccoonsToHome = 2;
		int numberRemainingRaccoons = numberOfRaccoons - numberOfRaccoonsToHome; 
		System.out.println(numberRemainingRaccoons);
		
        /*
        4. There are 5 flowers and 3 bees. How many less bees than flowers?
        */
 
		int numberOfFlowers = 5;
		int numberOfBees = 3; 
		int numberFewerBees = numberOfFlowers - numberOfBees;
		System.out.println(numberFewerBees);
		
        /*
        5. 1 lonely pigeon was eating breadcrumbs. Another pigeon came to eat
        breadcrumbs, too. How many pigeons are eating breadcrumbs now?
        */

		int numberLonelyPigeon = 1;
		int numberAddedFriendlyPigeon = 1;
		int numberPigeonsEating = numberLonelyPigeon + numberAddedFriendlyPigeon;
		System.out.println(numberPigeonsEating);
		
        /*
        6. 3 owls were sitting on the fence. 2 more owls joined them. How many
        owls are on the fence now?
        */

		int numberFenceOwls = 3;
		int numberJoinerOwls = 2;
		int numberTotalOwls = numberFenceOwls + numberJoinerOwls;
		System.out.println(numberTotalOwls);
		
        /*
        7. 2 beavers were working on their home. 1 went for a swim. How many
        beavers are still working on their home?
        */

		int numberWorkingBeavers = 2;
		int numberSwimmingBeavers = 1;
		int numberRemainingBeavers = numberWorkingBeavers - numberSwimmingBeavers;
		System.out.println(numberRemainingBeavers);
		
        /*
        8. 2 toucans are sitting on a tree limb. 1 more toucan joins them. How
        many toucans in all?
        */

		int numberTreeSittingToucans = 2;
		int numberJoiningToucans = 1;
		int numberTotalToucans = numberTreeSittingToucans + numberJoiningToucans;
		System.out.println(numberTotalToucans);
		
        /*
        9. There are 4 squirrels in a tree with 2 nuts. How many more squirrels
        are there than nuts?
        */

		int numberOfSquirrelsInTree = 4;
		int numberOfNutsInTree = 2;
		int numberOfSquirrelsExceedingNuts= numberOfSquirrelsInTree - numberOfNutsInTree;
		System.out.println(numberOfSquirrelsExceedingNuts);
        /*
        10. Mrs. Hilt found a quarter, 1 dime, and 2 nickels. How much money did
        she find?
        */
		int numberOfQuartersFound = 1;
		int valueOfQuartersInPennies = 25;
		int numberOfDimesFound = 1;
		int valueOfDimesInPennies = 10;
		int numberOfNickelsFound = 2;
		int valueofNickelsInPennies = 5;
		int changeInQuarters = numberOfQuartersFound * valueOfQuartersInPennies;
		int changeInDimes = numberOfDimesFound * valueOfDimesInPennies;
		int changeInNickels = numberOfNickelsFound * valueofNickelsInPennies;
		int totalChangeInPennies = changeInQuarters + changeInDimes + changeInNickels;
		float totalChangeInDollars = totalChangeInPennies / 100f; 
		String totalChangeInDollarsExpressedInMonetaryValue = "$" + totalChangeInDollars;
		System.out.println(totalChangeInDollarsExpressedInMonetaryValue);

        /*
        11. Mrs. Hilt's favorite first grade classes are baking muffins. Mrs. Brier's
        class bakes 18 muffins, Mrs. MacAdams's class bakes 20 muffins, and
        Mrs. Flannery's class bakes 17 muffins. How many muffins does first
        grade bake in all?
        */

		int numberMuffinsBrier = 18;
		int numberMuffinsMacAdams = 20;
		int numberMuffinsFlannery = 17;
		int numberTotalMuffinsForFirstGrade= numberMuffinsBrier + numberMuffinsMacAdams + numberMuffinsFlannery;
		System.out.println(numberTotalMuffinsForFirstGrade);
		
        /*
        12. Mrs. Hilt bought a yoyo for 24 cents and a whistle for 14 cents. How
        much did she spend in all for the two toys?
        */

		int moneySpentOnYoyoInPennies= 24;
		int moneySpentOnWhistleInPennies = 14;
		int costOfTwoToysInPennies = moneySpentOnYoyoInPennies + moneySpentOnWhistleInPennies;
		float costOfTwoToysInDollars = costOfTwoToysInPennies / 100f;
		String totalCostInDollarsExpressedInMonetaryValue = "$" + costOfTwoToysInDollars;
		System.out.println(totalCostInDollarsExpressedInMonetaryValue);
        /*
        13. Mrs. Hilt made 5 Rice Krispie Treats. She used 8 large marshmallows
        and 10 mini marshmallows.How many marshmallows did she use
        altogether?
        */

		int numberBigMarshmallows = 8;
		int numberTinyMarshmallows = 10;
		int totalMarshmallows = numberBigMarshmallows + numberTinyMarshmallows;
		System.out.println(totalMarshmallows);
        /*
        14. At Mrs. Hilt's house, there was 29 inches of snow, and Brecknock
        Elementary School received 17 inches of snow. How much more snow
        did Mrs. Hilt's house have?
        */

		int inchesOfSnowHiltHouse = 29;
		int inchesOfSnowBrecknockES = 17;
		int differenceInSnowFall= inchesOfSnowHiltHouse - inchesOfSnowBrecknockES;
		String differenceInSnowFallWithUnitIndicator = differenceInSnowFall + " inches";
		System.out.println(differenceInSnowFallWithUnitIndicator);
        /*
        15. Mrs. Hilt has $10. She spends $3 on a toy truck and $2 on a pencil
        case. How much money does she have left?
        */

		int startingCashReserveInDollars = 10;
		int dollarsSpentOnToy = 3;
		int dollarsSpentOnPencilCase = 2;
		int moneyLeftOver = startingCashReserveInDollars - dollarsSpentOnToy - dollarsSpentOnPencilCase;
		String remainingMoneyWithUnitIndicator = "$" + moneyLeftOver;
		System.out.println(remainingMoneyWithUnitIndicator);
        /*
        16. Josh had 16 marbles in his collection. He lost 7 marbles. How many
        marbles does he have now?
        */

		int marbleCollectionTotal = 16;
		int missingMarbles = 7;
		int numberMarblesRemaining = marbleCollectionTotal - missingMarbles;
		System.out.println(numberMarblesRemaining);
        /*
        17. Megan has 19 seashells. How many more seashells does she need to
        find to have 25 seashells in her collection?
        */

		int numberDesiredSeashells = 25;
		int seashellsAlreadyCollected = 19;
		int numberSeashellsNeeded = numberDesiredSeashells - seashellsAlreadyCollected;
		System.out.println(numberSeashellsNeeded);
		
        /*
        18. Brad has 17 balloons. 8 balloons are red and the rest are green. How
        many green balloons does Brad have?
        */

		int totalNumberOfBalloons = 17;
		int redBalloonsInBunch= 8;
		int remainingBalloonsThatAreGreen = totalNumberOfBalloons - redBalloonsInBunch;
		System.out.println(remainingBalloonsThatAreGreen);
        /*
        19. There are 38 books on the shelf. Marta put 10 more books on the shelf.
        How many books are on the shelf now?
        */

		int booksAlreadyOnShelfInBeginning = 38;
		int booksShelvedByMarta = 10;
		int booksOnTheShelfNow = booksAlreadyOnShelfInBeginning + booksShelvedByMarta;
		System.out.println(booksOnTheShelfNow);
        /*
        20. A bee has 6 legs. How many legs do 8 bees have?
        */
		//Could be interpreted two different ways. It says a bee has 6 legs, and then asks how many legs 8 bees have. Since it was just established that a bee has 6 legs, normally, I would say that bees have 6 legs, no matter how many bees are present. The fact that there are more or less bees doesn't change the fact that bees have 6 legs. However, I will assume that this problem is meant to indicate the total number of bee legs present. 
		
		int legsPerBee = 6;
		int beesPresentAtTheSceneOfTheStinging = 8;
		int beeLegsInvolvedInTheCrime = legsPerBee * beesPresentAtTheSceneOfTheStinging;
		System.out.println(beeLegsInvolvedInTheCrime);
        /*
        21. Mrs. Hilt bought an ice cream cone for 99 cents. How much would 2 ice
        cream cones cost?
        */

		int costOfIceCreamConeInPennies = 99;
		int numberOfIceCreamConesPurchased = 2;
		int moneySpentOnIceCreamConesInPennies = costOfIceCreamConeInPennies * numberOfIceCreamConesPurchased;
		float moneySpentOnIceCreamConesInDollars = moneySpentOnIceCreamConesInPennies / 100f;
		String moneySpentOnIceCreamConesInDollarsWithUnitIndicator = "$" + moneySpentOnIceCreamConesInDollars;
		System.out.println(moneySpentOnIceCreamConesInDollarsWithUnitIndicator);
        /*
        22. Mrs. Hilt wants to make a border around her garden. She needs 125
        rocks to complete the border. She has 64 rocks. How many more rocks
        does she need to complete the border?
        */

		int rocksNeededForBorder = 125;
		int rocksAlreadyObtained = 64;
		int rocksNeededForCompletion = rocksNeededForBorder - rocksAlreadyObtained;
		System.out.println(rocksNeededForCompletion);
        /*
        23. Mrs. Hilt had 38 marbles. She lost 15 of them. How many marbles does
        she have left?
        */

		int marblesMrsHiltStartedWith = 38;
		int marblesSheLost = 15;
		int marblesMrsHiltHasLeft = marblesMrsHiltStartedWith - marblesSheLost;
		System.out.println(marblesMrsHiltHasLeft);
        /*
        24. Mrs. Hilt and her sister drove to a concert 78 miles away. They drove 32
        miles and then stopped for gas. How many miles did they have left to drive?
        */

		int distanceToConcertInMiles = 78;
		int milesDrivenBeforePitStop = 32;
		int milesToDriveBeforePartyTime = distanceToConcertInMiles - milesDrivenBeforePitStop;
		System.out.println(milesToDriveBeforePartyTime);
        /*
        25. Mrs. Hilt spent 1 hour and 30 minutes shoveling snow on Saturday
        morning and 45 minutes shoveling snow on Saturday afternoon. How
        much total time did she spend shoveling snow?
        */

		int saturdayMorningHoursShovelingSnow = 1;
		int saturdayHoursIntoMinutes = saturdayMorningHoursShovelingSnow * 60;
		int saturdayMorningMinutesShovelingSnowOriginallyListedInMinutes= 30;
		int totalStaurdayMorningMinutesShovelingSnow = saturdayHoursIntoMinutes + saturdayMorningMinutesShovelingSnowOriginallyListedInMinutes;
		int afternoonMinutesSpentShovelingSnowOnSaturday = 45;
		int totalNumberMinutesShovelingSnowOnSaturday = totalStaurdayMorningMinutesShovelingSnow + afternoonMinutesSpentShovelingSnowOnSaturday;
		float totalTimeShovelingSnowOnSaturdayInHours = totalNumberMinutesShovelingSnowOnSaturday / 60f;
		String bothUnitsOfMeasurementForShovelingSnowWithUnitIndicators = totalNumberMinutesShovelingSnowOnSaturday + " minutes " + ", or " + totalTimeShovelingSnowOnSaturdayInHours + " hours";
		System.out.println(bothUnitsOfMeasurementForShovelingSnowWithUnitIndicators);
		
        /*
        26. Mrs. Hilt bought 6 hot dogs. Each hot dog cost 50 cents. How much
        money did she pay for all of the hot dogs?
        */

		int numberOfHotDogsBought = 6;
		int costOfHotDogsInPennies = 50;
		int moneyPaidForHotDogsPurchaseInPennies = numberOfHotDogsBought * costOfHotDogsInPennies;
		int moneySpentOnHotDogsInDollars = moneyPaidForHotDogsPurchaseInPennies / 100;
		String moneySpentOnHotDogsWithUnitIndicator = "$" + moneySpentOnHotDogsInDollars;
		System.out.println(moneySpentOnHotDogsWithUnitIndicator);
        /*
        27. Mrs. Hilt has 50 cents. A pencil costs 7 cents. How many pencils can
        she buy with the money she has?
        */

		int costOfPencilsInPennies = 7;
		int moneyMrsHiltHasForPencilsInPennies = 50;
		int numberOfPencilsThatCanBeHad = moneyMrsHiltHasForPencilsInPennies / costOfPencilsInPennies;
		System.out.println(numberOfPencilsThatCanBeHad);
        /*
        28. Mrs. Hilt saw 33 butterflies. Some of the butterflies were red and others
        were orange. If 20 of the butterflies were orange, how many of them
        were red?
        */

		int numberOfButterfliesFluttering = 33;
		int butterfliesThatAreOrange = 20;
		int numberOfRedButterfliesInTheSwarm = numberOfButterfliesFluttering - butterfliesThatAreOrange; 
		System.out.println(numberOfRedButterfliesInTheSwarm);
        /*
        29. Kate gave the clerk $1.00. Her candy cost 54 cents. How much change
        should Kate get back?
        */

		int dollarsGivenToClerk = 1;
		int moneyGivenToClerkInPennies = dollarsGivenToClerk * 100;
		int costOfCandyInPennies = 54;
		int changeDueBackInPennies = moneyGivenToClerkInPennies - costOfCandyInPennies;
		float changeDueExpressedInDollars = changeDueBackInPennies / 100f;
		String changeDueToCustomerWithUnitIndicator = "$" + changeDueExpressedInDollars;
		System.out.println(changeDueToCustomerWithUnitIndicator);
        /*
        30. Mark has 13 trees in his backyard. If he plants 12 more, how many trees
        will he have?
        */

		int treesAlreadyInYard = 13;
		int treesToBePlanted = 12;
		int totalTreesForTheFuture = treesAlreadyInYard + treesToBePlanted;
		System.out.println(totalTreesForTheFuture);
        /*
        31. Joy will see her grandma in two days. How many hours until she sees
        her?
        */

		int numberOfDaysUntilReunion = 2;
		int numberOfHoursInADay = 24;
		int hoursUntilGrandmaHugs = numberOfDaysUntilReunion * numberOfHoursInADay;
		System.out.println(hoursUntilGrandmaHugs);
        /*
        32. Kim has 4 cousins. She wants to give each one 5 pieces of gum. How
        much gum will she need?
        */

		int numberOfCousins = 4;
		int piecesOfGumPerCousin = 5;
		int howMuchGumWillBeNeeded = numberOfCousins * piecesOfGumPerCousin;
		System.out.println(howMuchGumWillBeNeeded);
        /*
        33. Dan has $3.00. He bought a candy bar for $1.00. How much money is
        left?
        */

		int dollarsDanHas = 3;
		int dollarsSpentOnCandyBar = 1;
		int moneyRemainingInDollars = dollarsDanHas - dollarsSpentOnCandyBar;
		String dollarsSpentOnCandyBarWithUnitIndicator = "$" + moneyRemainingInDollars;
		System.out.println(dollarsSpentOnCandyBarWithUnitIndicator);
        /*
        34. 5 boats are in the lake. Each boat has 3 people. How many people are
        on boats in the lake?
        */

		int boatsInTheLake = 5;
		int peoplePerBoat = 3;
		int drunkenBoatersWatchingTheFireworksOnBoatsInTheWater = boatsInTheLake * peoplePerBoat;
		System.out.println(drunkenBoatersWatchingTheFireworksOnBoatsInTheWater);
        /*
        35. Ellen had 380 legos, but she lost 57 of them. How many legos does she
        have now?
        */

		int legosEllenStartedWith = 380;
		int legosLostToTheAbyss = 57;
		int remainingNumberOfLegosWaitingToStabYouInTheFoot = legosEllenStartedWith - legosLostToTheAbyss;
		System.out.println(remainingNumberOfLegosWaitingToStabYouInTheFoot);
        /*
        36. Arthur baked 35 muffins. How many more muffins does Arthur have to
        bake to have 83 muffins?
        */

		int muffinsHadByArthur = 35;
		int muffinsNeededToPleaseTheMasses = 83;
		int muffinsArthurHasToBake = muffinsNeededToPleaseTheMasses - muffinsHadByArthur;
		System.out.println(muffinsArthurHasToBake);
        /*
        37. Willy has 1400 crayons. Lucy has 290 crayons. How many more
        crayons does Willy have then Lucy?
        */

		int crayonsControlledByWillie = 1400;
		int numberOfCrayonsInLucysPatheticCollection = 290;
		int numberOfCrayonsThatWiliieDominatesLucysCollectionBy = crayonsControlledByWillie - numberOfCrayonsInLucysPatheticCollection;
		System.out.println(numberOfCrayonsThatWiliieDominatesLucysCollectionBy);
        /*
        38. There are 10 stickers on a page. If you have 22 pages of stickers, how
        many stickers do you have?
        */

		int pagesOfStickerFun = 22;
		int amountOfFunStickersPerPage = 10;
		int maximumStickerFunToBeHadByAll = pagesOfStickerFun * amountOfFunStickersPerPage;
		System.out.println(maximumStickerFunToBeHadByAll);
        /*
        39. There are 96 cupcakes for 8 children to share. How much will each
        person get if they share the cupcakes equally?
        */

		int cupcakesAtTheParty = 96;
		int numberOfStickyChildren = 8;
		int perChildCupcakeQuota = cupcakesAtTheParty / numberOfStickyChildren;
		System.out.println(perChildCupcakeQuota);
        /*
        40. She made 47 gingerbread cookies which she will distribute equally in
        tiny glass jars. If each jar is to contain six cookies each, how many
        cookies will not be placed in a jar?
        */

		int numberOfGingerbreadCookies = 47;
		int numberOfCookiesPerJar = 6;
		int numberOfCookieJarsFilledToCapacity = numberOfGingerbreadCookies / numberOfCookiesPerJar;
		int numberOfCookiesThatRemainWholeAndGoInJars = numberOfCookieJarsFilledToCapacity * numberOfCookiesPerJar;
		int numberLeftOverCookies = numberOfGingerbreadCookies - numberOfCookiesThatRemainWholeAndGoInJars;
		System.out.println(numberLeftOverCookies);
		
        /*
        41. She also prepared 59 croissants which she plans to give to her 8
        neighbors. If each neighbor received and equal number of croissants,
        how many will be left with Marian?
        */

		int totalNumberOfCroissants = 59;
		int neighborsThatWillReceiveCroissants = 8;
		int numberOfWholeCroissantsDistributedPerPerson = totalNumberOfCroissants / neighborsThatWillReceiveCroissants;
		int totalNumberOfGiftedCroissants = neighborsThatWillReceiveCroissants * numberOfWholeCroissantsDistributedPerPerson;
		int croissantsLeftForMarian = totalNumberOfCroissants - totalNumberOfGiftedCroissants;
		System.out.println(croissantsLeftForMarian);
        /*
        42. Marian also baked oatmeal cookies for her classmates. If she can
        place 12 cookies on a tray at a time, how many trays will she need to
        prepare 276 oatmeal cookies at a time?
        */
		
		int cookiesPerTray = 12;
		int cookiesNeededForClass = 276;
		int numberOfTraysNeeded = cookiesNeededForClass / cookiesPerTray;
		System.out.println(numberOfTraysNeeded);

        /*
        43. Marian’s friends were coming over that afternoon so she made 480
        bite-sized pretzels. If one serving is equal to 12 pretzels, how many
        servings of bite-sized pretzels was Marian able to prepare?
        */

		int numberOfDeliciousPretzels = 480;
		int pretzelsInAServing = 12;
		int servingsOfPretzelsAvailable = numberOfDeliciousPretzels / pretzelsInAServing;
		System.out.println(servingsOfPretzelsAvailable);
        /*
        44. Lastly, she baked 53 lemon cupcakes for the children living in the city
        orphanage. If two lemon cupcakes were left at home, how many
        boxes with 3 lemon cupcakes each were given away?
        */

		int lemonCupcakesBaked = 53;
		int cupcakesLeftAtHomeForTheCats = 2;
		int cupcakesAvailableToGiveAway = lemonCupcakesBaked - cupcakesLeftAtHomeForTheCats;
		int cupcakesPerBox = 3;
		int boxesNeededForCupcakes = cupcakesAvailableToGiveAway / cupcakesPerBox;
		System.out.println(boxesNeededForCupcakes);
        /*
        45. Susie's mom prepared 74 carrot sticks for breakfast. If the carrots
        were served equally to 12 people, how many carrot sticks were left
        uneaten?
        */

		int carrotsReadyForGrossestBreakfastEver = 74;
		int numberOfPeopleGivenBreakfastCarrots = 12;
		int carrotsServedButProbablyNotEatenPerPerson = carrotsReadyForGrossestBreakfastEver / numberOfPeopleGivenBreakfastCarrots;
		int totalCarrotsServedToBreakfastHostages = numberOfPeopleGivenBreakfastCarrots * carrotsServedButProbablyNotEatenPerPerson;
		int carrotsLeftOverForTomorrowsHostages = carrotsReadyForGrossestBreakfastEver - totalCarrotsServedToBreakfastHostages;
		System.out.println(carrotsLeftOverForTomorrowsHostages);
        /*
        46. Susie and her sister gathered all 98 of their teddy bears and placed
        them on the shelves in their bedroom. If every shelf can carry a
        maximum of 7 teddy bears, how many shelves will be filled?
        */

		int totalNumberOfTeddyBears = 98;
		int maxNumberBearsPerShelf = 7;
		int shelvesNeededForBearCollection = totalNumberOfTeddyBears / maxNumberBearsPerShelf;
		System.out.println(shelvesNeededForBearCollection);
        /*
        47. Susie’s mother collected all family pictures and wanted to place all of
        them in an album. If an album can contain 20 pictures, how many
        albums will she need if there are 480 pictures?
        */
		
		int numberFamilyPictures = 480;
		int photosPerAlbum = 20;
		int numberAlbumsNeededForEntireCollection = numberFamilyPictures / photosPerAlbum;
		System.out.println(numberAlbumsNeededForEntireCollection);

        /*
        48. Joe, Susie’s brother, collected all 94 trading cards scattered in his
        room and placed them in boxes. If a full box can hold a maximum of 8
        cards, how many boxes were filled and how many cards are there in
        the unfilled box?
        */

		int tradingCardsInRoom = 94;
		int maxNumberCardsPerBox = 8;
		int boxesFilledWithCards = tradingCardsInRoom / maxNumberCardsPerBox;
		int numberCardsFillingBoxes = boxesFilledWithCards * maxNumberCardsPerBox;
		int leftOverCardsInUnfilledBox = tradingCardsInRoom - numberCardsFillingBoxes;
		System.out.println(leftOverCardsInUnfilledBox);
        /*
        49. Susie’s father repaired the bookshelves in the reading room. If he has
        210 books to be distributed equally on the 10 shelves he repaired,
        how many books will each shelf contain?
        */

		int totalNumberOfBooks = 210;
		int shelvesAvailableForBooks = 10;
		int booksPerShelf = totalNumberOfBooks / shelvesAvailableForBooks;
		System.out.println(booksPerShelf);
        /*
        50. Cristina baked 17 croissants. If she planned to serve this equally to
        her seven guests, how many will each have?
        */
		
		int croissantsAvailable = 17;
		int guestsEatingCroissants = 7;
		int croissantsPerGuest = croissantsAvailable / guestsEatingCroissants;
		System.out.println(croissantsPerGuest);

        /*
            CHALLENGE PROBLEMS
        */

        /*
        Bill and Jill are house painters. Bill can paint a 12 x 14 room in 2.15 hours, while Jill averages
        1.90 hours. How long will it take the two painter working together to paint 5 12 x 14 rooms?
        Hint: Calculate the hourly rate for each painter, combine them, and then divide the total walls in feet by the combined hourly rate of the painters.
        Challenge: How many days will it take the pair to paint 623 rooms assuming they work 8 hours a day?.
        */
		
		double timePerRoomBillInHours = 2.15d;
		int areaOfRoomSquareFeet= 12 * 14;
		double squareFeetPaintedInHourBill = areaOfRoomSquareFeet / timePerRoomBillInHours;
		double timeJillTakesToPaintRoomInHours = 1.9d;
		double squareFeetJillPaintsInHour = areaOfRoomSquareFeet / timeJillTakesToPaintRoomInHours;
		double totalSquareFeetPaintedByBothInHour = squareFeetPaintedInHourBill + squareFeetJillPaintsInHour;
		int areaNeededToBePainted = areaOfRoomSquareFeet * 5;
		double hoursToPaintFiveRooms = areaNeededToBePainted / totalSquareFeetPaintedByBothInHour;
		System.out.println(hoursToPaintFiveRooms);

        /*
        Create and assign variables to hold your first name, last name, and middle initial. Using concatenation,
        build an additional variable to hold your full name in the order of last name, first name, middle initial. The
        last and first names should be separated by a comma followed by a space, and the middle initial must end
        with a period.
        Example: "Hopper, Grace B."
        */

		String firstName = "Amanda";
		String middleInitial = "L.";
		String lastName = "Saylor";
		String fullName = lastName + ", " + firstName + " " + middleInitial;
		System.out.println(fullName);
        /*
        The distance between New York and Chicago is 800 miles, and the train has already travelled 537 miles.
        What percentage of the trip has been completed?
        Hint: The percent completed is the miles already travelled divided by the total miles.
        Challenge: Display as an integer value between 0 and 100 using casts.
        */

		int distanceBetweenCities = 800;
		int distanceAlreadyCovered = 537;
		int percentDistanceTravelled = (int) ((distanceAlreadyCovered * 100) / distanceBetweenCities);
		System.out.println(percentDistanceTravelled);
	}

}
