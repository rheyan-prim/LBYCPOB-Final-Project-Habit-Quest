1.	Project Title: Habit Quest

2.	Team Members: Haile Gabriel C. Chico (hailegabriel-chico)
	                Rafael S. Diongco (rafaeldiongco)
		              Rheyan Miguel B. Prim (rheyan-prim)
3.	Problem Statement & Goals:
       - Many individuals struggle to build consistency and stay motivated when trying to form long-term, positive habits. Traditional checklist apps often feel repetitive and demotivating, lacking the immediate, engaging feedback loop needed to sustain motivation for personal growth or to allow users to personalize their experience visually and habitually.
       What are the main objectives of your application?
       - To gamify habit building by applying RPG-style progression in order for users to maintain motivation and increase consistency with their chosen healthy habits.
       - To use Object Oriented Programming to provide users with a highly personal experience for their personal growth, where they can create and define their own unique habits.
4.	Target Users:
       - Students and working professionals seeking an engaging way to manage daily routines.
       - Gamers and productivity enthusiasts who respond well to video game mechanics like leveling up and maintaining win streaks.
5.	Brief Description: 
Habit Quest is a gamified habit-tracking application that transforms daily personal development into an interactive RPG experience. Users can create customized habit "quests," complete with personalized descriptions and image uploads. When a user marks a habit as complete, they are rewarded with experience points (XP) that contribute to their overall level. To encourage daily consistency, the system tracks habit completion streaks, unlocking an increasing XP multiplier for higher streaks. End-to-end, the app handles user authentication, data persistence for custom habit objects, dynamic leveling calculations, and a responsive frontend dashboard.
6.	Core OOP Concepts:
    List the OOP principles you intend to apply and where they'll show up, e.g.:
-   Encapsulation - We will protect vital user and progression metrics by making fields like currentXP, level, and streakCount private within classes like User and Habit. This data can 			only be modified through secure public methods like gainXP(int amount) and incrementStreak(), ensuring game logic rules cannot be bypassed.
-   Inheritance - Habit → DailyQuestHabit, ToDoQuestHabitWe will create a general Habit base class containing shared properties like title, description, and imagePath, which will then be 			extended into specialized subclasses to handle different behavior rules for daily repetitions versus one-time tasks. 
-	Polymorphism - calculateXPReward() → overridden per habit type We will override a single reward method across different habit subclasses so the system can dynamically 							calculate a flat XP rate for standard daily tasks while scaling higher XP rewards for difficult, one-time epic quests.
-	Abstraction - Rewardable interface → implemented by DailyQuestHabit, ToDoQuestHabitWe will use an interface to enforce a grantReward(User user) blueprint, hiding the complex under-			the-hood leveling math from the frontend UI so the dashboard can trigger rewards with a single, clean method call. 
7.	Initial Class Ideas:
-   User: Acts as the central container for the user’s identity and global progression.
      Responsibilities: Manages authentication state, stores totalXP, currentLevel, and maintains a collection (List<Habit>) of all habits created by the user.
-   Habit (Base/Abstract Class): The blueprint for all tasks.
      Responsibilities: Holds common attributes like title, description, imagePath, and completionStatus. It defines the interface for calculating rewards.
-   QuestManager: The "controller" class that acts as a bridge between the UI and your data models.
      Responsibilities: Handles the logic for validating task completion, triggering the XP distribution, and checking if the User has earned enough XP to level up.
-   StreakTracker: A utility class dedicated to temporal logic.
      Responsibilities: Tracks dates of completion, calculates the current streak length, and computes the active XP multiplier based on that streak.

8.	User Stories: Short feature descriptions from the end-user's perspective:
- As a gamer and productivity enthusiast, I want my habits to reward me with XP and levels so that I feel a sense of RPG-style progression and stays motivated to maintain my routines.
- As a student or working professional, I want to create custom habits with my own titles, descriptions, and uploaded images through the UI so that my dashboard feels personalized to my specific lifestyle.
- As an everyday user, I want the app to track my daily completion streaks and apply an XP multiplier so that I am visually and mechanically incentivized to not break my habit loops.
- As a security-conscious user, I want to log into a secure account so that my custom habits, personal stats, and level progress are saved and protected across different sessions.

9. Core Features: A bulleted list of the main functions your system will support (e.g., user login, inventory tracking, sales reporting, receipt generation).
- Interactive Quest Dashboard: The dashboard is an interactive way to show all the users active habits in a format of "quest cards" each displaying how much of a bar you have completed toward reaching your next level.
- Dynamic XP and Multiplication Service: A back-end service to calculate XP based upon the difficulty of completing a specific habit and then apply a multiplication factor (such as 1.5X or 2X) for completing consecutive days of a habit.
- Custom Habit Creation: A flow through which the user can create his/her own habits by entering what they are trying to do (and the image associated), and then rate how difficult it will be to maintain the new habit. This rating influences the amount of XP he/she may earn for successfully maintaining the new habit.
- Persistence Layer (data repository): System for saving and loading user state (the habits they created, the number of days into their streak, etc.) when they close out their session; this prevents them from losing their progress.
- Streak Integrity Monitoring: Logic that automatically resets a streak if a mandatory daily habit is not completed, incentivizing users to check in every day.