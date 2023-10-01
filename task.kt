class Task (
    val taskName: String, //variable to track name of task
    val taskDescription: String,
    val taskTime: Int, //variable to track estimated required for completion
    val taskPriority: Int, //variable to track task priority
    var taskStatus: Boolean = false//variable to track status of the task (true for done, false for not done)
) {

}