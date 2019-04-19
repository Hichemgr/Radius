<?php

namespace SlimBundle\Controller;

use SlimBundle\Entity\Assisstance;
use SlimBundle\Entity\Assisstant;
use SlimBundle\Entity\Conseil;
use SlimBundle\Entity\Utilisateur;
use SlimBundle\Form\AssisstanceType;
use SlimBundle\Form\AssisstantType;
use SlimBundle\Form\ConseilType;
use Symfony\Bundle\FrameworkBundle\Controller\Controller;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\Routing\Annotation\Route;


class DefaultController extends Controller
{
    public function indexAction()
    {
        return $this->render('@Slim/Default/index.html.twig');
    }
    public function indexfrontAction()
    {
        $proj2 = $this->getDoctrine()->getRepository(Conseil::class)->findAll();
        return $this->render('@Slim/Default/indexfront.html.twig', array('Conseil'=>$proj2));

    }
    public function singlepostAction(Request $request)
    {
        $proj2 = $this->getDoctrine()->getRepository(Conseil::class)->findAll();
        $Assisstance = new Assisstance();
        $Assisstant = new Assisstant();
        $form = $this->createForm(AssisstanceType::class, $Assisstance);
        $form->handleRequest($request);
        $etatassisstant="dispo";
        $idclient=1;
        $repo=$this->getDoctrine()->getRepository(Assisstant::class);
        $assisstant=$repo->findOneBy(array('etat' => $etatassisstant));
        $this->denyAccessUnlessGranted("IS_AUTHENTICATED_FULLY");
        $idd= $this->getUser()->getId() ;
        if ($form->isValid()) {
            $em = $this->getDoctrine()->getManager();
            $article=(new \DateTime('now'));

            if(($article<$Assisstance->getDateass())&&($assisstant!=null)){
            $Assisstance->setIdAssisstant($assisstant);
            $Assisstance->setIdClient($idd);

            $em->persist($Assisstance);
            $em->flush();
            $etata="indispo";

            $repo1=$this->getDoctrine()->getRepository(Assisstant::class);
            $assisstant1=$repo1->findOneBy(array('idAssisstant' => $assisstant));
            $assisstant1->setEtat($etata);
            $em1 = $this->getDoctrine()->getManager();
            $em1->flush();}
            else
            { $this->get('session')->getFlashBag()->add(
                'notice',
                'Date invalide'
            );}
            return $this->redirectToRoute("slim_homepagefrontassisstance");
        }
        return $this->render('@Slim/Front/single-post.html.twig', array('Conseil'=>$proj2,'Assisstance_form' => $form->createView()));
    }
    public function ajoutAssisstanceAction(Request $request)
    {
        $Assisstance = new Assisstance();

        $form = $this->createForm(AssisstanceType::class, $Assisstance);
        $form->handleRequest($request);


        if ($form->isValid()) {
            $em = $this->getDoctrine()->getManager();


            $em->persist($Assisstance);
            $em->flush();
            return $this->redirectToRoute("ajoutAssisstance");
        }
        return $this->render("@Slim/Front/single-post.html.twig",
            array('Assisstance_form' => $form->createView()));
    }

    public function ajouterAssisstantAction(Request $request)
    {
        $Assisstant = new Assisstant();

        $form = $this->createForm(AssisstantType::class, $Assisstant);
        $form->handleRequest($request);
        if ($form->isValid()) {
            $em = $this->getDoctrine()->getManager();
            $em->persist($Assisstant);
            $em->flush();
            return $this->redirectToRoute("afficherAssisstant");
        }
        return $this->render("@Slim/Back/ajouterAssisstant.html.twig",
            array('Assisstant_form' => $form->createView()));
    }
    public function afficherAssisstantAction()
    {
        $proj = $this->getDoctrine()->getRepository(Assisstant::class)->findAll();
        $proj1 = $this->getDoctrine()->getRepository(Assisstance::class)->findAll();
        $proj2 = $this->getDoctrine()->getRepository(Conseil::class)->findAll();
        $article=(new \DateTime('now'));
        foreach($proj1 as $value)
        {
            if($value->getdateass()<=$article)
            {
                foreach($proj as $value1)
                {
                    if($value1->getIdAssisstant()==$value->getIdAssisstant())
                    {
                        $value1->setEtat("dispo");
                        $em = $this->getDoctrine()->getManager();
                        $em->persist($value1);
                        $em->flush();
                    }
                }
                $value->setIdAssisstant("0");
                $em = $this->getDoctrine()->getManager();
                $em->persist($value);
                $em->flush();

            }
        }
        return $this->render("@Slim/Back/afficherAssisstant.html.twig", array('Assisstant'=>$proj,'Assisstance'=>$proj1,'Conseil'=>$proj2));
    }
    public function supprimerAssisstantAction($IdAssisstant)
    {
        $em = $this->getDoctrine()->getManager();
        $post = $em->getRepository(Assisstant::class)->find($IdAssisstant);
        $em->remove($post);
        $em->flush();
        return $this->redirectToRoute("afficherAssisstant");
    }
    public function supprimerAssisstanceAction($idAssisstance)
    {


        $em = $this->getDoctrine()->getManager();
        $post = $em->getRepository(Assisstance::class)->find($idAssisstance);
        $idass="0";
        $etatd="dispo";
        $idassiss=$post->getIdAssisstant();
        $post->setIdAssisstant($idass);
        $repo1=$this->getDoctrine()->getRepository(Assisstant::class);
        $assisstant1=$repo1->findOneBy(array('idAssisstant' => $idassiss));
        $assisstant1->setEtat($etatd);
        $em1 = $this->getDoctrine()->getManager();
        $em1->flush();


        $em->flush();


        return $this->redirectToRoute("afficherAssisstant");
    }
    public function supprimerConseilAction($idConseil)
    {
        $em = $this->getDoctrine()->getManager();
        $post = $em->getRepository(Conseil::class)->find($idConseil);
        $em->remove($post);
        $em->flush();
        return $this->redirectToRoute("afficherAssisstant");
    }

    public function modifierAssisstantAction($IdAssisstant,Request $request){
        $cars=$this->getDoctrine()->getRepository(Assisstant::class)->find($IdAssisstant);
        $form=$this->createForm(AssisstantType::class,$cars);
        $form->handleRequest($request);
        if ($form->isValid()){
            $e = $this->getDoctrine()->getManager();
            $e->flush();
            return $this->redirectToRoute("afficherAssisstant");
        }
        return $this->render("@Slim/Back/modifierAssisstant.html.twig",array("form_modifier"=>$form->createView()));
    }


    public function modifierAssisstanceAction($idAssisstance,Request $request){
        $cars=$this->getDoctrine()->getRepository(Assisstance::class)->find($idAssisstance);
        $form=$this->createForm(AssisstanceType::class,$cars);
        $form->handleRequest($request);
        if ($form->isValid()){
            $e = $this->getDoctrine()->getManager();
            $e->flush();
            return $this->redirectToRoute("afficherAssisstant");
        }
        return $this->render("@Slim/Back/modifierAssisstance.html.twig",array("form_modifier"=>$form->createView()));
    }
    public function ajouterConseilAction(Request $request)
    {
        $Conseil = new Conseil();

        $form = $this->createForm(ConseilType::class, $Conseil);
        $form->handleRequest($request);
        if ($form->isValid()) {
            $em = $this->getDoctrine()->getManager();
            $em->persist($Conseil);
            $em->flush();
            return $this->redirectToRoute("afficherAssisstant");
        }
        return $this->render("@Slim/Back/ajouterConseil.html.twig",
            array('Conseil_form' => $form->createView()));
    }

    /**
     * @Route("/calendar", name="booking_calendar")
     */
    public function calendarAction()
    {
        return $this->render('@Slim/Back/calendar.html.twig');
    }
}
