import java.util.ArrayList;
import java.util.Stack;


public class StateGraph {

	public ArrayList<State> states;
	public static ArrayList<Transition> transitions;
	public static State initial_state;
	public State goal;
	
	public StateGraph()
	{
		states = new ArrayList<>();
		transitions = new ArrayList<>();
		initial_state = new State(3,3,"left");
		goal = new State(0,0,"right");
		states.add(initial_state);
		///graph creation starts here:
		run (initial_state, states, transitions);
	}
	public void run(State current, ArrayList<State> states, ArrayList<Transition> transitions)
	{

			if (current.get_side() == "left") // boat is on left
			{
				for (int i =0; i <= current.M_left; i++)
					for (int j =0; j <= current.C_left; j++)
					{
						if (i+j <= 2 && i+j >0)
						{
							//System.out.println("i+j = " + (i+j));
							State next = new State(current.C_left-j, current.M_left-i, "right");
							Transition tran = new Transition(current,next);
							if ( next.isValid())// && !transition_exists(transitions, tran))
							transitions.add(tran);
							if ( next.isValid() &&  !state_exists(states, next))//next.isValid()
							{
							states.add(next);
							//System.out.println("Next = " + next.print());
							run(next, states, transitions);
							}
							
						}
					}
			}
			else //boat is on right
			{		

				for (int i =0; i <= 3-current.M_left; i++)
					for (int j =0; j <= 3-current.C_left; j++)
					{
						if (i+j <= 2 && i+j >0)
						{
							//System.out.println("i+j = " + (i+j));
							State next = new State(current.C_left+j, current.M_left+i, "left");
							Transition tran = new Transition(current,next);
							if ( next.isValid())// && !transition_exists(transitions, tran))
							transitions.add(tran);
							if ( next.isValid() && !state_exists(states, next)) //
							{
							
							states.add(next);
							//System.out.println("Next = " + next.print());
							run(next, states, transitions);
							}
						}
					}

			}
//		}
		

	}
	public boolean state_exists(ArrayList<State> states_array, State state)
	{
		boolean result = false;
		for (State s : states_array)
		{
			if (state.isEqual(s))
			{
				result = true; break;
			}
		}
		return result;
	}
//	public boolean transition_exists(ArrayList<Transition> transition_array, Transition trans)
//	{
//		boolean result = false;
//		for (Transition s : transition_array)
//		{
//			if (trans.isEqual(s))
//			{
//				result = true; break;
//			}
//		}
//		return result;
//	}
	
	public static ArrayList<State> find_neighbors(ArrayList<Transition> transitions, State s)
	{
		ArrayList<State> neighbors = new ArrayList<State>();
		for ( Transition t : transitions)
		{
			if (t.from.isEqual(s))
				neighbors.add(t.to);
		}
		return neighbors;
	}
	
	public void dfs (State start_state)
	{
		//TO DO
		Stack<State> s = new Stack<State>();
		s.push(start_state);
		
		while (s.empty() ==false)
		{
			State top = s.pop();
			s.pop();
			if (top.isVisited==false)
			{
				top.isVisited = true;
				if (top.isEqual(goal))
				{
					System.out.println("FOUND IT!!!!");
				}
				else
				{
					ArrayList<State> neighbors = find_neighbors(transitions, top);
					if (neighbors.isEmpty())
						System.out.println("REACHED THE END");
					else
					{
						for (State temp : neighbors)
						{
							s.push(temp);
						}
					}
				}
			}
		}
	}
 public static void main(String[] args) {
	 
	 StateGraph sg = new StateGraph();
	 for (State t : find_neighbors(transitions, initial_state))
		 System.out.println(t.print());
 }
	
	
}