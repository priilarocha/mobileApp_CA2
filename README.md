# Mobile Apps 1 CA2

- Student Name: Priscila Rocha de Queiroz
- Student ID: 25337
- Course: Science in Computing

## Requirement Checklist

- [x] 1. Movie recycler view:
    - [x] 1.1. Create a Movie class with the structure specified in movie.json (provided on Moodle)
    - [x] 1.2. Obtain and fill data (minimum of 4 movies)
        - [x] 1.2.1. Obtain relevant movie data from Vue (https://www.myvue.com/cinema/dublin/whats-on) or your favourite provider and add data credits at the bottom of the app
        - [x] 1.2.2. Generate a random number between 0 and 15 for each movie and assign to seats_remaining
        - [x] 1.2.3. Start with an initial default seats_selected value of 0 for all movies
        - [x] 1.2.4. You shall fill random URLs for images from pixabay or other free image providers to begin with
    - [x] 1.3. Build a Recycler View using the specified template, refer to recycler_view_template_*.jpg (provided on Moodle)
    - [x] 1.4. If any seats are selected, show how many seats are selected and hide remaining seats
- [x] 2. Seat selection feature:
    - [x] 2.1. Clicking any item (anywhere on the item) on the movie recycler view should open a new MovieActivity, refer to movie_activity_*.jpg (provided on Moodle)
    - [x] 2.2. Add plus and minus icons, show seats_selected in the middle
    - [x] 2.3. On click plus/minus, update both seats_selected and seats_remaining for that movie
    - [x] 2.4. Add validation, when 0 seats selected minus is disabled, when 0 seats remaining plus is disabled
    - [x] 2.5. When back is pressed, the selected seats are retained and reflected in the recycler view. (Hint: If you don’t see any updates, call adapter notifyItemChanged as soon as you return to the recycler view activity)
- [ ] 3. Bonus:
    - [ ] 3.1. Add "filling fast" badge if less than 3 seats remaining
    - [ ] 3.2. Use "Roboto Condensed" font to replicate same style
    - [x] 3.3. Use original movie images from myvue.com or your favourite provider (Hint: check get_movie_image_url.gif (provided on Moodle))

## Additional Features implemented

Changed the font color to red when the seats were sold out.

## Report

This assignment was really challenging for me, there were a few problems and sometimes I had to change completely how I was conducting it, as I was going nowhere with some of the solutions I had thought of in the beginning, for example, my first idea to obtain all data was through an API, I was trying to connect to the IMDB API (that is a JSON file), I had created a key and all, but even trying several times and in different ways, it didn’t work, so I used the information in the JSON file from IMDB to create my own through Gist on GitHub. Then I had a problem with the size of the images (I check the Logcat and could see the following error: java.lang.runtimeexception: canvas: trying to draw too large(438394804bytes) bitmap) the app was working but after a time it was closing unexpectedly, so I changed all images links to another provider.
I had a problem with the layout it wasn’t showing the icons for all movies, this was a simple issue, I knew it was one of the layouts, but it took me a long time to see that the recyclerview height wasn’t wrapping the content.
I left part of my tries on using the IMDB API commented on the code, so during my holidays I can try it again as I will have more time to try it, this way my app will be always updated with the latest movies and there won’t be a limit of movies being shown (in my Gist I only included 5 movies).
Another thing that I know I need to study more is about GitHub. I had problems with my repository during the last class and had to create a new repository for this assignment, as I was unable to send anything there. But I couldn’t synchronize the branches, so the assignment is only available in the master branch.
This assignment besides being very stressful for me, made me learn a lot about creating a recyclerview, connecting to the internet, getting data from there, and how to work with JSON files. I could see also how gets easier even to analyse the error in the Logcat, which was really handled sometimes.


## References and Credits

1. View Binding. URL: [Link](https://developer.android.com/topic/libraries/view-binding)
2. Android extensions. URL: [Link](https://developer.android.com/topic/libraries/view-binding/migration#groovy)
3. Get data from internet. URL: [Link](https://developer.android.com/codelabs/basic-android-kotlin-training-getting-data-internet#0)
4. IMDB API. URL: [Link](https://imdb-api.com/api#InTheaters-header)
5. TextView wrongly set as ImageView. URL: [Link](https://stackoverflow.com/questions/12465551/android-widget-textview-cannot-be-cast-to-android-widget-button)

## APK Releases

1. CA2MovieApp [link](https://github.com/priilarocha/mobileApp_CA2/releases/tag/ca2)