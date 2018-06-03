module Challenge where

    data Node = Node{
        name :: String,
        nodeLevel :: Int,
        nodes :: [Node]
    } deriving(Eq, Show)

    type Dungeon = [Node]

    type StartNode = Node
    type EndNode = Node

    data Settings = Settings{
        depth :: Int
    }

    mockSettings = Settings {
        depth = 10
    }


    
    generateDungeon :: Settings -> Dungeon
    generateDungeon _ = []
    generateDungeon settings = generateBranches (depth settings)

    generateBranches :: Int -> Dungeon
    generateBranches 0 = []
    generateBranches depth =  [Node{ name = "A", nodeLevel = depth, nodes = generateBranches (depth + (-1))}]





    printDungeon dungeon = do{
        putStrLn "dungeon";
    }