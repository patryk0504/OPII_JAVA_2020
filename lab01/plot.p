set term png
set output "wykres.png"
set xrange [0:100]
set yrange [0:100]
plot "dane.txt" ps 0.1