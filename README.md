# Plotte
## What is Plotte?
A plotting program implemented in Java.
It's designed to be easily usable with UNIX pipes. For example, you can pipe in results from Sorte, a sorting program.
## How do I install it?
Go to releases and download the jar, then run it:
```
java -jar Plotte.jar
```
If you're using unix, you *may* be able to just move the file to /usr/local/bin/ and be able to run it anywhere.

Depending on your system, you might not be able to dotslash execute the jar. You can either change these settings or
create bash script that runs the java command and forwards the given arguments. A quick google search can help you with
either of those options.
## License
> Plotte - a simple plotting program | Copyright (C) 2016  Sebastian Vikkelsø Elleholm
>
> This program is free software: you can redistribute it and/or modify
> it under the terms of the GNU General Public License as published by
> the Free Software Foundation, either version 3 of the License, or
> (at your option) any later version.
>
> This program is distributed in the hope that it will be useful,
> but WITHOUT ANY WARRANTY; without even the implied warranty of
> MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
> GNU General Public License for more details.
>
> You should have received a copy of the GNU General Public License
> along with this program.  If not, see <http://www.gnu.org/licenses/>.

Full license provided in LICENSE file.