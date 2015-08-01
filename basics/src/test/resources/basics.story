Sample story

Narrative:
In order to communicate effectively to the business some functionality
As a development team
I want to use Behaviour-Driven Development

Scenario:  Ny ansokan och galdenar finns ej
Given ny ansokan med persorgnr 20121212-1212

When ansokan skickas in
And efter att all aktivitet har avstannat

Then antal mal = 1
Then antal utskrifter = 2
Then antal arkiveringar = 2
Then antal arbetsuppgifter = 0
					 
Scenario:  Ny ansokan for samma galdenar som nu finns
Given ny ansokan

When ansokan skickas in
And efter att all aktivitet har avstannat

Then antal mal = 1
Then antal utskrifter = 2
Then antal arkiveringar = 2
Then antal arbetsuppgifter = 0
