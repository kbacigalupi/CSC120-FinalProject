# CSC120-FinalProject
What was your overall approach to tackling this project?
I started by drawing a map of the project. From the game map, I made a list of classes and their potential attributes and 
I then worked on implementing each data structure that I needed for the game. Once I had the data structures, I started with implementing the paddle and portage functions in a basic game loop. That was one of the most difficult parts. It was also hard to think through how all the different data structures needed to interact. For example, the items weren't originally public, but I found that so many classes needed to access items & their names, so I made every location and its attributes public. I also then had to figure out how to get the users input as a string to correlate to an item or location.

What new thing(s) did you learn / figure out in completing this project?
I learned a lot about google guava. I was learning about graphs in discrete math around the same time, so I thought it was interesting to be able to represent these structures in java. I'm excited to learn more about what this really means next semester. I also think that the google guava implementation worked a lot better than an array of arrays would. The "Map" class could've been implemented as an array of arrays. However, the map I drew in my brainstroming phase wasn't well represented by an array of arrays. There was not straight east/west or north/south movement. I also wanted some locations to be accessible from a variety of other locations and that could not be done through an array of arrays. 

In addition, this seems like a small and dumb thing to learn this semester, but it reiterated the difference between = and .equals. I was trying to change my descriptions of each location after the user picks up the item, and was using the wrong equals (.equals()) for a long time before I worked through the bug.

Is there anything that you wish you had implemented differently/If you had unlimited time, what additional features would you implement?
I wish my commands were all one word so I could use a switch statement. It didn't feel like it was worth it or made sense to change the commands and logic surrounding them just to be able to switch on one word. I attempted to do this, 
I wanted to make the "trivia" part of the game more exciting, but I ran out of time and energy to fix this part. I would want to make the game more compelling and interesting, and I think changing the trivia questions to different activities would be a big part of this. It could also be made more insteresting/educational by implementing a chat bot that could tell the user the information they need to successfully play the game. 

I think I would also work on testing-potentially by having the scanner read a file instead of having to type in everything to test the game. I can only guess/hope that there are not major bugs that I missed.

What was the most helpful piece of feedback you received while working on your project? Who gave it to you?
I think it was helpful to hear that there should be more connection between the locations. Originally, the user had to go through the lake to get from place to place. Now they can move from campsite to campsite if the campsites are next to each other. I received this feedback from my classmates after they test played the game. 
It was also helpful to hear that I should try a switch() command from you. Even though I couldn't implement it in the controller, I used it in the Location class. I still definitely need practice-I couldn't get the switch function to work unless I wrote a "break" statement after every case.

If you could go back in time and give your past self some advice about this project, what hints would you give?
I would tell her that it's ok to write messy methods the first time (and also end up keeping them messy. Sometimes you can only give so much time and energy in a really stressful time generally.) I would say every instinct you have in creating or changing a data structure-whether a new arraylist or the need to make something public for other classes to access it was right. 



