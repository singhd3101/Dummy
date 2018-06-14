
public class ApplicationMemory {
	
	/**
	 * The memory that is allocated to a program while execution is typically
	 *  divided into four sections
	 *   
	 * 1) Code(Text) -    section stores all the instructions to be executed.
	 * 
	 * 2) Static/Global - section to store global variables. Not cleared for 
	 * the lifetime of the application.
	 *  
	 * 3) Stack -         used as scratch pad for function call execution, where
	 *  all the local variables go, all the information about function call
	 *  execution. When a program starts execution, first main method is invoked. 
	 *  Whenever a method is
	 *  invoked, some memory from the stack gets allocated for the execution
	 *  of that method. That section is called stack frame of that method and
	 *  all the local variables of that method lives inside stack frame. When 
	 *  method call execution finishes, the stack frame is reclaimed. When
	 *  main makes a call to another method, the execution of main will pause
	 *  at the line where its making a call, a stack frame will be allocated to
	 *  the called method. All the arguments and local variables of that method
	 *  will live inside this next stack frame.We cannot control allocation and
	 *  deallocation of memory on stack. It happens automatically.
	 *  
	 * 4) Heap - also called dynamic memory. For a section of memory in heap we
	 * cannot have a direct name, we need an address. 
	 */
}
