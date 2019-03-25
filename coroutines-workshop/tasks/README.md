# Oslo Kotlin Meetup - Coroutines workshop tasks
The thing you have all been looking forward to; experimenting with coroutines for yourselves! Try to read the entire task text (or listen when Marie is going through them!) before trying the tasks ;) 


## Main task: Existing customer fetching API
Your task is to optimize a (very simple) customer reporting system for an online shop. This online shop saves ids, names and store points for each customer. The reporting system should use the existing API for fetching customers, sort them by the points in descending order, and then simply print them to the console (standard output). A sequential implementation (including time measurement and basic coroutine setup) is given in `CustomerReporter.kt` (src/main/kotlin/net/themkat/meetup/oslo/coroutines/workshop/customer). You can use this as a starting point if you'd like :) 

What is the point you may ask? When working with coroutines, you often have to work with existing APIs that you may not have control over. Coroutines are in these cases used as optimizations where you pack existing API calls into them to execute the tasks asynchronously. Treat `Customer.kt` and `CustomerFetch.kt` as an existing API. 



## Extra task: Calculating Pi
If you want more, or you got bored of customers, there is another task you could try! Think Pi is a peculiar number? So do we! If you are curious on reading more about the formula itself, you could [head over to Wolfram Alpha](http://mathworld.wolfram.com/WallisFormula.html) (not necessary to solve the tasks, but still fun).


### Task: Thinking of `WallisPI.kt` as an existing API
The first (and probably most boring) task you could do is to wrap calls to the wallisPi function into coroutines. In the file `PiCalc.kt` (src/main/kotlin/net/themkat/meetup/oslo/coroutines/workshop/pi) we have a scenario where we would like to start with accuracy parameter 10 000 000 (number of iterations), and calculate the next 100 different accuracy parameters. We print each of the calculations together with their accuracy parameter. Wrap it into coroutines or explore some other idea you may have :)


### Fun extra: Wrap the Wallis Pi calculation into coroutines!
You may have noticed that the bigger the number, the higher the run time for the Wallis Pi formula. Maybe you would like to try to wrap the calculation itself into coroutines? Try and have fun! Note that the organizers haven't had time to make a solution for this, so this is the perfect way to get nerd cred from us ;) 



