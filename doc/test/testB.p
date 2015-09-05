// subprogramas (paso por valor) funciones

program doce;

var
        z,v: integer;
		x: boolean;

function decrementa (x:integer):integer;

var
        y:integer;

        begin
            y:= 1;
            decrementa:=y;

        end;

begin

        write ("SUBPROGRAMAS FUNCIONES");
        writeln();

        x:=z-3;
		x:=z>2;
        v:= decrementa (z);

        write("v(2):");
        write(v);
end.
