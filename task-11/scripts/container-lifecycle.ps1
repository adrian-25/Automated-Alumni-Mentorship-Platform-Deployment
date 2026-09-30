param([string]$Tag = "alumni-mentorship:v1.0.0", [int]$Port = 8081)

docker build -f task-11/Dockerfile -t $Tag .
docker run -d --name alumni-mentorship-demo -p "${Port}:8080" $Tag
docker ps --filter "name=alumni-mentorship-demo"
Invoke-WebRequest -UseBasicParsing "http://localhost:${Port}/alumni-mentorship/api/health"
docker logs alumni-mentorship-demo
docker restart alumni-mentorship-demo
docker stop alumni-mentorship-demo
docker start alumni-mentorship-demo
# When finished: docker rm -f alumni-mentorship-demo
