Scenario:  Ny ansokan och galdenar finns ej
Given ny ansokan med persorgnr 19121212-1212

When ansokan skickas in
And efter att all aktivitet har avstannat

Then antal mal = 1
