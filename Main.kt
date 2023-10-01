fun main (){

    //Boolean to check if program should terminate
    var done = false
    var choice = 0

    //Initiating list to store task objects
    var taskList: MutableList<Task> = mutableListOf()

    while (!done){

        //Displaying message
        displayMessage()

        //Getting input
        choice = getInput()


        //Statement to execute appropriate action based on user input
        when (choice){
            1 -> {
                taskList.add(collectTaskInfo())//Collecting new task info from user
            }
            2 -> {
                displayTasks(taskList)//Displaying existing tasks
            }
            3 -> {
                taskList = editTaskStatus(taskList)//Updating task completion status
            }
            4 -> {
                done = true//Ending loop (user wants to quit)
            }
            else -> println("\nPlease enter a valid input\n")
        }


    }

}

/*
This function displays a message to the user prompting them to make a decision
Parameter: None
Return: None
*/
fun displayMessage(){
    println("Would you like to:")
    println("1. Add a new task")
    println("2. View all tasks")
    println("3. Update task status")
    println("4. Quit the program")
    print("Input: ")
}

/*
This function gets input from the user and returns and integer to be used with conditionals
Parameter: None
Return: integer
*/
fun getInput (): Int{
    val input = readln()
    return input.toInt()
}


/*
This function collects task info and adds a the data to a list
Parameter: A list with type Task (class)
Return: None
*/
fun collectTaskInfo(): Task{


    println()
    print("Please enter the task name: ")
    val taskName = readln()

    println()
    print("Please enter a brief task description: ")
    val taskDescription = readln()

    println()
    print("Please enter the estimated amount of time the task will take (min): ")
    val taskTime = readln()

    println()
    print("On a scale of 1 to 10, please rank the priority of this task: ")
    val taskPriority = readln()

    //Instantiating and returning task object
    return Task(taskName, taskDescription, taskTime.toInt(), taskPriority.toInt())

}


/*
This function displays the task objects
Parameter: None
Return: None
*/
fun displayTasks(list: List<Task>){
    var taskNum = 1

    for (task in list){
        println("\nTask #$taskNum")
        println("Name: ${task.taskName}")
        println("Description: ${task.taskDescription}")
        println("Priority (1-10): ${task.taskPriority}")
        println("Estimated time: ${task.taskTime}")
        if (task.taskStatus){
            println("Status: Done")
        }
        else println("Status: Not done")
        println()

        taskNum++
    }
}

/*
This function allows the user to update the status of a task
Parameter: List of tasks
Return: Updated list of tasks
*/
fun editTaskStatus (taskList: MutableList<Task>): MutableList<Task>{
    //Displaying tasks
    displayTasks(taskList)

    //Ask user for specific task to update status
    print("Enter the number of the task you would like to change to done: ")
    val taskNum = readln()


    //Isolating task object to be updated
    val taskToUpdate = taskList[taskNum.toInt() - 1]

//    Updating member variable Boolean status
    taskToUpdate.taskStatus = true

    println("\nStatus updated\n")

    return taskList
}