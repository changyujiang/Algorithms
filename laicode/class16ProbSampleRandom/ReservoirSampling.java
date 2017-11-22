package laicode.class16ProbSampleRandom;

/*Reservoir Sampling
Consider an unlimited flow of data elements. 
How do you sample one element from this flow, 
such that at any point during the processing of the flow, 
you can return a random element from the n elements read so far.

You will implement two methods for a sampling class:

read(int value) - read one number from the flow
sample() - return at any time the sample, 
if n values have been read, the probability of returning any one of the n values is 1/n, return null(Java)/INT_MIN(C++) if there is no value read so far
You may need to add more fields for the class.*/

//0. keypoint
//unlimited data flow; sample one element form this flow

//1. assumption
//flow is int

//2. approach
//reservoir sampling
//once read a integer, generate a random number [0,countSoFar)
//if random == 0; we replace sample with this integer

//example:
//a b c d e f g
//when count = 1, 
//p(a) = 1
//when count = 2
//p(b) = 1/2 p(a) = 1*(1-1/2)
//when count = 3
//p(c) = 1/3 p(b) = 1/2*(1-1/3)=1/3 p(a)= 1/2*(1-1/3)=1/3
//and so on ...

//3. data structure
//we need to main a count and a sample so far

//4. comment

//5. big o complexity
//time: O(n) for n items
//space: O(1)
public class ReservoirSampling {
	Integer sample;
	int countSoFar;

	public ReservoirSampling() {
		this.sample = null;
		this.countSoFar = 0;
	}

	public void read(int value) {
		countSoFar++;
		int random = (int) (Math.random() * countSoFar);
		if (random == 0) {
			sample = value;
		}
	}

	public Integer sample() {
		return sample;
	}
}
