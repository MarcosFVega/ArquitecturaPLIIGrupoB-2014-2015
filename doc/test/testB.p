// subprogramas (paso por valor) procedimientos

program once;

	var
    z: integer;
	
	procedure decrementa (x,w,d:integer );

	var
		y:integer;

	begin		
		y:= x-1;
		write("y(2):");
		write(y);
	end;

begin

        write ("SUBPROGRAMAS PROCEDIMIENTOS");
        writeln();

        z:=1;
        decrementa (z,true);


end.
