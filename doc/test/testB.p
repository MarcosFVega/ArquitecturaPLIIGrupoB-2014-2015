// subprogramas (paso por valor) funciones

program doce;



var
        z,v: integer;


procedure decrementa (x:integer);

var
        y:integer;

        begin
            y:= z-1;
            decrementa(y);

        end;

begin

        write ("SUBPROGRAMAS FUNCIONES");
        writeln();

        z:=3;
        v:= decrementa (z);

       // write("v(2):");
        //write(v);
end.
