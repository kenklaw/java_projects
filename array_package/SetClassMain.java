package array_package;


public class SetClassMain
{
    public static void main(String[] args)
	{
		SetClass sc_1 = new SetClass();
		SetClass sc_2 = new SetClass();
		SetClass sc_3 = new SetClass();

		SetClass sc_Union = new SetClass();
		SetClass sc_Intersection = new SetClass();
		SetClass sc_relComplement = new SetClass();
	
		sc_1.loadItems( 5, 10, 1 );
		sc_2.loadItems( 1, 10, 1 );
		sc_3.loadItems( 10, 3, 10 );
	
		System.out.println( "Universal Set: " + sc_1.toString() );
		System.out.println( "Set 2: " + sc_2.toString()  );	
		System.out.println( "Set 3: " + sc_3.toString()  );

		sc_Union = sc_1.findUnion( sc_2 );
		sc_Intersection = sc_1.findIntersection( sc_2 );
		sc_relComplement = sc_1.findComplement( sc_3 );

		System.out.println("\n");
	
		System.out.println( "Union -- Sets 1 & 2: " + sc_Union.toString()  );     
	
		System.out.println( "Intersection -- Sets 1 & 2: " 
							+ sc_Intersection.toString()  );       

		System.out.println( "Relative complement -- Sets 1 & 2: " 
							+ sc_relComplement.toString() );
	}

}
