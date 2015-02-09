
public class Transition {

	public State from, to;
	public String boat_direction;
	public Transition(State a, State b)
	{
		
	from = a; to = b;
	if (b.get_side() == "right")
		boat_direction = "LR";
	else
		boat_direction = "RL";
	
	}
	public String print()
	{
		return "transition(" + from.print() +" to " + to.print();
	}
	public boolean isEqual(Transition t)
	{
		if ((t.to.isEqual(to) && t.from.isEqual(from) ))//|| (t.from.isEqual(to) && t.to.isEqual(from))) ) 
			return true;
		else
			return false;
	}
	
	public boolean contains_state( State s)
	{
		if (from.isEqual(s) || to.isEqual(s))
			return true;
		else
			return false;
	}
	
}
