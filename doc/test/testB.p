// subprogramas (paso por valor) procedimientos

program once;



var
        z: integer;


procedure decrementa (x,f,v:integer);

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

        z:=3;
        decrementa (z,8,8);


end.
